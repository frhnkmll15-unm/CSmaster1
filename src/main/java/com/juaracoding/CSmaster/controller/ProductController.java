package com.juaracoding.CSmaster.controller;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Moh. Ikhsan a.k.a. Fitriyani
Java Developer
Created on 3/12/2023 3:28 PM
@Last Modified 3/12/2023 3:28 PM
Version 1.0
*/

import com.juaracoding.CSmaster.configuration.OtherConfig;
import com.juaracoding.CSmaster.dto.CategoryDTO;
import com.juaracoding.CSmaster.dto.ProductDTO;

import com.juaracoding.CSmaster.model.Product;
import com.juaracoding.CSmaster.service.CategoryService;
import com.juaracoding.CSmaster.service.ProductService;
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
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
	@Autowired
	private ModelMapper modelMapper;

    @Autowired
    private CategoryService categoryService;

    private MappingAttribute mappingAttribute = new MappingAttribute();

    private Map<String, Object> objectMapper = new HashMap<String, Object>();

    private static String UPLOADED_FOLDER = "user-photos/";
	private PdfGeneratorLibre generator = null;
	private String [][] strBody = null;
	private String [] strExceptionArr = new String[2];
	private Map<String,String> mapSorting = new HashMap<String,String>();
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;//wajib di deklarasikan kalau pakai thymeleaf engine

	private StringBuilder sBuild = new StringBuilder();
	public ProductController(ProductService productService) {
		strExceptionArr[0] = "ProductController";
		mapSorting();
		this.productService = productService;

	}

	private void mapSorting()
	{
		mapSorting.put("id","idCategory");
		mapSorting.put("nama","namaCategory");
	}


    @GetMapping("/list")
    public String listProductPage(Model model, WebRequest request, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }

        Page<Product> products = productService.findAllProduct(page, size);

        model.addAttribute("products", products);
        model.addAttribute("currentPage", products.getNumber() + 1);
        model.addAttribute("totalItems", products.getTotalElements());
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("product", new Product());

        return "/product/list";
    }

    @GetMapping("/new")
    public String createProduct(Model model, WebRequest request) {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }
        model.addAttribute("product", new ProductDTO());
        model.addAttribute("categories", categoryService.findAllCategory());

        return "product/create_product";
    }

    @GetMapping("/edit/{kodeProduct}")
    public String editProduct(Model model, WebRequest request, @PathVariable("kodeProduct") String kodeProduct) {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }
        Product product = productService.findProductById(kodeProduct);

        if (product == null) {
            mappingAttribute.setAttribute(model, objectMapper);
            model.addAttribute("message", "DATA BERHASIL DISIMPAN");
            Long idDataSave = objectMapper.get("idDataSave") == null ? 1 : Long.parseLong(objectMapper.get("idDataSave").toString());
            return "redirect:/api/product/list";
        }

        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAllCategory());

        return "product/edit_product";
    }

    @PostMapping(value = "/update/{kodeProduct}")
    public String editProduct(@ModelAttribute(value = "product")
                             @Valid ProductDTO productDTO
            , BindingResult bindingResult
            , Model model
            , WebRequest request, @PathVariable("kodeProduct") String kodeProduct
    ) throws IOException {
        if (OtherConfig.getFlagSessionValidation().equals("y")) {
            mappingAttribute.setAttribute(model, objectMapper, request);//untuk set session
            if (request.getAttribute("USR_ID", 1) == null) {
                return "redirect:/api/check/logout";
            }
        }

        if (kodeProduct == null) {
            model.addAttribute("product", productDTO);
            model.addAttribute("status", "error");
            model.addAttribute("categories", categoryService.findAllCategory());

            return "redirect:/api/product/edit/" + kodeProduct;
        }

        model.addAttribute("categories", categoryService.findAllCategory());

        /* START VALIDATION */
        if (bindingResult.hasErrors()) {
            model.addAttribute("product", productDTO);
            model.addAttribute("status", "error");
            model.addAttribute("categories", categoryService.findAllCategory());

            return "redirect:/api/product/edit/" + kodeProduct;
        }

        Boolean isValid = true;

        if (!isValid) {
            model.addAttribute("product", productDTO);
            return "redirect:/api/product/edit/" + kodeProduct;
        }
        /* END OF VALIDATION */


        Product product = modelMapper.map(productDTO, new TypeToken<Product>() {
        }.getType());

        Product productExisting = productService.findProductById(kodeProduct);
        System.out.println(productDTO.getImage().getOriginalFilename());
        if (productDTO.getImage().getOriginalFilename() != null && !productDTO.getImage().isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
            String randomTimestamp  = dateFormat.format(new Date());
            String fileName = StringUtils.cleanPath(randomTimestamp + productDTO.getImage().getOriginalFilename());
            FileUploadUtil.saveFile(UPLOADED_FOLDER, fileName, productDTO.getImage());

            productExisting.setImage(fileName);
        }

        Object strUserIdz = request.getAttribute("USR_ID",1);
        productExisting.setModifiedBy(Integer.parseInt(strUserIdz.toString()));
        productExisting.setModifiedDate(new Date());
        productExisting.setNamaProduct(product.getNamaProduct());
        productExisting.setMerkProduct(product.getMerkProduct());
        productExisting.setDescription(product.getDescription());
        productExisting.setCategory(product.getCategory());

        objectMapper = productService.save(productExisting, request);
        if (objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if ((Boolean) objectMapper.get("success")) {
            mappingAttribute.setAttribute(model, objectMapper);
            model.addAttribute("message", "DATA BERHASIL DISIMPAN");
            Long idDataSave = objectMapper.get("idDataSave") == null ? 1 : Long.parseLong(objectMapper.get("idDataSave").toString());
            return "redirect:/api/product/list";
        } else {
            mappingAttribute.setErrorMessage(bindingResult, objectMapper.get("message").toString());
            model.addAttribute("category", new CategoryDTO());
            model.addAttribute("status", "error");
            return "redirect:/api/product/edit/" + kodeProduct;
        }
    }

    @PostMapping(value = "/new")
    public String newProduct(@ModelAttribute(value = "product")
                             @Valid ProductDTO productDTO
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
            model.addAttribute("product", productDTO);
            model.addAttribute("status", "error");
            model.addAttribute("categories", categoryService.findAllCategory());

            return "product/create_product";
        }
        Boolean isValid = true;

        if (!isValid) {
            model.addAttribute("product", productDTO);
            return "product/create_product";
        }
        /* END OF VALIDATION */

        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        String randomTimestamp  = dateFormat.format(new Date());
        String fileName = StringUtils.cleanPath(randomTimestamp + productDTO.getImage().getOriginalFilename());
        FileUploadUtil.saveFile(UPLOADED_FOLDER, fileName, productDTO.getImage());

        Product product = modelMapper.map(productDTO, new TypeToken<Product>() {
        }.getType());

        product.setImage(fileName);

        objectMapper = productService.save(product, request);
        if (objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if ((Boolean) objectMapper.get("success")) {
            mappingAttribute.setAttribute(model, objectMapper);
            model.addAttribute("message", "DATA BERHASIL DISIMPAN");
            Long idDataSave = objectMapper.get("idDataSave") == null ? 1 : Long.parseLong(objectMapper.get("idDataSave").toString());
            return "redirect:/api/product/list";
        } else {
            mappingAttribute.setErrorMessage(bindingResult, objectMapper.get("message").toString());
            model.addAttribute("category", new CategoryDTO());
            model.addAttribute("status", "error");
            return "product/create_product";
        }
    }

    @GetMapping("/delete/{kodeProduct}")
    public String doRegis(Model model
            , WebRequest request
            , @PathVariable("kodeProduct") String kodeProduct
    )
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }
        objectMapper = productService.deleteProduct(kodeProduct,request);
        if(objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if((Boolean) objectMapper.get("success"))
        {
            mappingAttribute.setAttribute(model,objectMapper);
            model.addAttribute("product",new ProductDTO());
            return "redirect:/api/product/list";//LANGSUNG DITAMPILKAN FOKUS KE HASIL EDIT USER TADI
        }
        else
        {
//            mappingAttribute.setErrorMessage(bindingResult,objectMapper.get("message").toString());
            model.addAttribute("product",new ProductDTO());
            return "/product/list";
        }
    }
	@GetMapping("/v1/product/xportpdflibre")
	public void exportToPDFLibre(
			Model model,
			@RequestParam String columnFirst,
			@RequestParam String valueFirst,
			WebRequest request,
			HttpServletResponse response
	){
		mappingAttribute.setAttribute(model,request);//untuk set session ke attribut
		List<ProductDTO> listProductDTO= productService.dataToExport(request,columnFirst,valueFirst);
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDHHMMSS.sss");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		sBuild.setLength(0);
		String headervalue = sBuild.append("attachment; filename=productlist").
				append(currentDateTime).append(".pdf").toString();
		response.setHeader(headerkey, headervalue);
		generator = new PdfGeneratorLibre();
		int intStrHeader=4;// INI YANG DIRUBAH SESUAIKAN DENGAN JUMLAH KOLOM
		String[] strHeader = new String[intStrHeader];
        /*
            DEFINISIKAN KOLOM NYA DISINI HARUS SESUAI JUMLAH NYA DENGAN HEADER YANG DI SET DI VARIABEL intStrHeader
         */
		strHeader[0] ="KodeProduct";
		strHeader[1] ="NamaProduct";
		strHeader[2] ="NerkProduct";
		strHeader[3] ="Description";
		strHeader[4] ="Image";
		int intListProductDTO = listProductDTO.size();
		strBody = new String[intListProductDTO][intStrHeader];

		for(int i=0;i<listProductDTO.size();i++)
		{
            /*
                INI KALIAN MAPPING TAPI HATI2 DENGAN OBJECT, HARUS DI HANDLE NULL NYA
             */


			strBody[i][0] = String.valueOf(listProductDTO.get(i).getKodeProduct());
			strBody[i][1] = listProductDTO.get(i).getNamaProduct();
			strBody[i][2] = listProductDTO.get(i).getMerkProduct();
			strBody[i][3] = listProductDTO.get(i).getDescription();
			strBody[i][4] = String.valueOf(listProductDTO.get(i).getImage());

		}

		sBuild.setLength(0);
		generator.generate(sBuild.
				append("SISTEM INFORMASI PENANGANAN KELUHAN PELANGGAN \n").//JUDUL REPORT
						append("List Category                                                        Total Data : ").append(intListProductDTO).//VARIABEL TOTAL DATA
						toString(),strHeader,strBody, response);
	}

}
