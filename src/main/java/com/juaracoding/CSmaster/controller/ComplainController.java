package com.juaracoding.CSmaster.controller;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Moh. Ikhsan a.k.a. Fitriyani
Java Developer
Created on 3/19/2023 1:41 PM
@Last Modified 3/19/2023 1:41 PM
Version 1.0
*/


import com.juaracoding.CSmaster.configuration.OtherConfig;
import com.juaracoding.CSmaster.dto.CategoryDTO;
import com.juaracoding.CSmaster.dto.ComplainDTO;

import com.juaracoding.CSmaster.model.Complain;

import com.juaracoding.CSmaster.service.CategoryService;
import com.juaracoding.CSmaster.service.ComplainService;

import com.juaracoding.CSmaster.utils.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/complain")
public class ComplainController {

    @Autowired
    private ComplainService complainService;

    @Autowired
    private CategoryService categoryService;

    private MappingAttribute mappingAttribute = new MappingAttribute();

    private Map<String, Object> objectMapper = new HashMap<String, Object>();

    private static String UPLOADED_FOLDER = "user-photos/";

	private PdfGeneratorLibre generator = null;
	private String [][] strBody = null;
	private String [] strExceptionArr = new String[2];
	private Map<String,String> mapSorting = new HashMap<String,String>();
	private ModelMapper modelMapper;
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;//wajib di deklarasikan kalau pakai thymeleaf engine

	private StringBuilder sBuild = new StringBuilder();
	public ComplainController(ComplainService complainService) {
		strExceptionArr[0] = "ComplainController";
		mapSorting();
		this.complainService = complainService;

	}

	private void mapSorting()
	{
		mapSorting.put("NoInvoice","noInvoice");
		mapSorting.put("NamaProduct","namaProduct");
		mapSorting.put("MerkProduct","merkProduct");
		mapSorting.put("Description","description");
		mapSorting.put("Image","image");
	}

    @GetMapping("v1/complain/default")
    public String listComplainPage(Model model, WebRequest request, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }

        Page<Complain> complains = complainService.findAllComplain(page, size);

        model.addAttribute("complains", complains);
        model.addAttribute("currentPage", complains.getNumber() + 1);
        model.addAttribute("totalItems", complains.getTotalElements());
        model.addAttribute("totalPages", complains.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("complain", new Complain());

        return "/complain/list";
    }

    @GetMapping("/new")
    public String createComplain(Model model, WebRequest request) {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }
        model.addAttribute("complain", new ComplainDTO());
        model.addAttribute("categories", categoryService.findAllCategory());

        return "complain/create_complain";
    }

    @GetMapping("/edit/{noInvoice}")
    public String editComplain(Model model, WebRequest request, @PathVariable("noInvoice") String noInvoice) {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }
        Complain complain = complainService.findComplainById(noInvoice);

        if (complain == null) {
            mappingAttribute.setAttribute(model, objectMapper);
            model.addAttribute("message", "DATA BERHASIL DISIMPAN");
            Long idDataSave = objectMapper.get("idDataSave") == null ? 1 : Long.parseLong(objectMapper.get("idDataSave").toString());
            return "redirect:/api/complain/list";
        }

        model.addAttribute("complain", complain);
        model.addAttribute("categories", categoryService.findAllCategory());

        return "complain/edit_complain";
    }

    @PostMapping(value = "/update/{noInvoice}")
    public String editComplain(@ModelAttribute(value = "complain")
                              @Valid ComplainDTO complainDTO
            , BindingResult bindingResult
            , Model model
            , WebRequest request, @PathVariable("noInvoice") String noInvoice
    ) throws IOException {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }

        if (noInvoice == null) {
            model.addAttribute("compalin", complainDTO);
            model.addAttribute("status", "error");
            model.addAttribute("categories", categoryService.findAllCategory());

            return "redirect:/api/complain/edit/" + noInvoice;
        }

        model.addAttribute("categories", categoryService.findAllCategory());

        /* START VALIDATION */
        if (bindingResult.hasErrors()) {
            model.addAttribute("complain", complainDTO);
            model.addAttribute("status", "error");
            model.addAttribute("categories", categoryService.findAllCategory());

            return "redirect:/api/complain/edit/" + noInvoice;
        }

        Boolean isValid = true;

        if (!isValid) {
            model.addAttribute("complain", complainDTO);
            return "redirect:/api/complain/edit/" + noInvoice;
        }
        /* END OF VALIDATION */


        Complain complain = modelMapper.map(complainDTO, new TypeToken<Complain>() {
        }.getType());

        Complain complainExisting = complainService.findComplainById(noInvoice);
        System.out.println(complainDTO.getImage().getOriginalFilename());
        if (complainDTO.getImage().getOriginalFilename() != null && !complainDTO.getImage().isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
            String randomTimestamp  = dateFormat.format(new Date());
            String fileName = StringUtils.cleanPath(randomTimestamp + complainDTO.getImage().getOriginalFilename());
            FileUploadUtil.saveFile(UPLOADED_FOLDER, fileName, complainDTO.getImage());

           complainExisting.setImage(fileName);
        }

        Object strUserIdz = request.getAttribute("USR_ID",1);
        complainExisting.setModifiedBy(Integer.parseInt(strUserIdz.toString()));
        complainExisting.setModifiedDate(new Date());
        complainExisting.setNamaProduct(complain.getNamaProduct());
        complainExisting.setMerkProduct(complain.getMerkProduct());
        complainExisting.setDescription(complain.getDescription());
        complainExisting.setCategory(complain.getCategory());

        objectMapper = complainService.save(complainExisting, request);
        if (objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if ((Boolean) objectMapper.get("success")) {
            mappingAttribute.setAttribute(model, objectMapper);
            model.addAttribute("message", "DATA BERHASIL DISIMPAN");
            Long idDataSave = objectMapper.get("idDataSave") == null ? 1 : Long.parseLong(objectMapper.get("idDataSave").toString());
            return "redirect:/api/complain/list";
        } else {
            mappingAttribute.setErrorMessage(bindingResult, objectMapper.get("message").toString());
            model.addAttribute("category", new CategoryDTO());
            model.addAttribute("status", "error");
            return "redirect:/api/complain/edit/" + noInvoice;
        }
    }

    @PostMapping(value = "/new")
    public String newComplain(@ModelAttribute(value = "complain")
                             @Valid ComplainDTO complainDTO
            , BindingResult bindingResult
            , Model model
            , WebRequest request
    ) throws IOException {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }

        model.addAttribute("categories", categoryService.findAllCategory());

        /* START VALIDATION */
        if (bindingResult.hasErrors()) {
            model.addAttribute("complain", complainDTO);
            model.addAttribute("status", "error");
            model.addAttribute("categories", categoryService.findAllCategory());

            return "complain/create_complain";
        }
        Boolean isValid = true;

        if (!isValid) {
            model.addAttribute("complain", complainDTO);
            return "complain/create_complain";
        }
        /* END OF VALIDATION */

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        String randomTimestamp  = dateFormat.format(new Date());
        String fileName = StringUtils.cleanPath(randomTimestamp + complainDTO.getImage().getOriginalFilename());
        FileUploadUtil.saveFile(UPLOADED_FOLDER, fileName, complainDTO.getImage());

        Complain complain= modelMapper.map(complainDTO, new TypeToken<Complain>() {
        }.getType());

        complain.setImage(fileName);

        objectMapper = complainService.save(complain, request);
        if (objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if ((Boolean) objectMapper.get("success")) {
            mappingAttribute.setAttribute(model, objectMapper);
            model.addAttribute("message", "DATA BERHASIL DISIMPAN");
            Long idDataSave = objectMapper.get("idDataSave") == null ? 1 : Long.parseLong(objectMapper.get("idDataSave").toString());
            return "redirect:/api/complain/list";
        } else {
            mappingAttribute.setErrorMessage(bindingResult, objectMapper.get("message").toString());
            model.addAttribute("category", new CategoryDTO());
            model.addAttribute("status", "error");
            return "complain/create_complain";
        }
    }

    @GetMapping("/delete/{noInvoice}")
    public String doRegis(Model model
            , WebRequest request
            , @PathVariable("noInvoice") String noInvoice
    )
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }
        objectMapper = complainService.deleteComplain(noInvoice,request);
        if(objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if((Boolean) objectMapper.get("success"))
        {
            mappingAttribute.setAttribute(model,objectMapper);
            model.addAttribute("complain",new ComplainDTO());
            return "redirect:/api/complain/list";//LANGSUNG DITAMPILKAN FOKUS KE HASIL EDIT USER TADI
        }
        else
        {
//            mappingAttribute.setErrorMessage(bindingResult,objectMapper.get("message").toString());
            model.addAttribute("complain",new ComplainDTO());
            return "/complain/list";
        }
    }
	@GetMapping("/v1/complain/xportpdflibre")
	public void exportToPDFLibre(
			Model model,
			@RequestParam String columnFirst,
			@RequestParam String valueFirst,
			WebRequest request,
			HttpServletResponse response
	){
		mappingAttribute.setAttribute(model,request);//untuk set session ke attribut
		List<ComplainDTO> listComplainDTO= complainService.dataToExport(request,columnFirst,valueFirst);
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDHHMMSS.sss");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		sBuild.setLength(0);
		String headervalue = sBuild.append("attachment; filename=complainlist").
				append(currentDateTime).append(".pdf").toString();
		response.setHeader(headerkey, headervalue);
		generator = new PdfGeneratorLibre();
		int intStrHeader=4;// INI YANG DIRUBAH SESUAIKAN DENGAN JUMLAH KOLOM
		String[] strHeader = new String[intStrHeader];
        /*
            DEFINISIKAN KOLOM NYA DISINI HARUS SESUAI JUMLAH NYA DENGAN HEADER YANG DI SET DI VARIABEL intStrHeader
         */
		strHeader[0] ="NoInvoice";
		strHeader[1] ="NamaProduct";
		strHeader[2] ="MerkProduct";
		strHeader[3] ="Description";
		strHeader[4] ="Image";
		int intListComplainDTO = listComplainDTO.size();
		strBody = new String[intListComplainDTO][intStrHeader];

		for(int i=0;i<listComplainDTO.size();i++)
		{
            /*
                INI KALIAN MAPPING TAPI HATI2 DENGAN OBJECT, HARUS DI HANDLE NULL NYA
             */


			strBody[i][0] = String.valueOf(listComplainDTO.get(i).getNoInvoice());
			strBody[i][1] = listComplainDTO.get(i).getNamaProduct();
			strBody[i][2] = listComplainDTO.get(i).getMerkProduct();
			strBody[i][3] = listComplainDTO.get(i).getDescription();
			strBody[i][4] = String.valueOf(listComplainDTO.get(i).getImage());

		}

		sBuild.setLength(0);
		generator.generate(sBuild.
				append("SISTEM INFORMASI PENANGANAN KELUHAN PELANGGAN \n").//JUDUL REPORT
						append("List Category                                                        Total Data : ").append(intListComplainDTO).//VARIABEL TOTAL DATA
						toString(),strHeader,strBody, response);
	}

}
