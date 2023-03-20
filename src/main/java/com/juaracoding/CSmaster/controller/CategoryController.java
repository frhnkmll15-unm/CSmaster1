package com.juaracoding.CSmaster.controller;

import com.juaracoding.CSmaster.configuration.OtherConfig;
import com.juaracoding.CSmaster.dto.CategoryDTO;
import com.juaracoding.CSmaster.model.Category;

import com.juaracoding.CSmaster.service.AksesService;
import com.juaracoding.CSmaster.service.CategoryService;

import com.juaracoding.CSmaster.service.DivisiService;
import com.juaracoding.CSmaster.service.MenuService;
import com.juaracoding.CSmaster.utils.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/api/item")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    private Map<String,Object> objectMapper = new HashMap<String,Object>();
    private Map<String,String> mapSorting = new HashMap<String,String>();

    private List<Category> lsCPUpload = new ArrayList<Category>();

    private String [] strExceptionArr = new String[2];

    private MappingAttribute mappingAttribute = new MappingAttribute();

	private PdfGeneratorLibre generator = null;
	private String [][] strBody = null;
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;//wajib di deklarasikan kalau pakai thymeleaf engine

	private StringBuilder sBuild = new StringBuilder();
	public CategoryController(CategoryService categoryService) {
		strExceptionArr[0] = "CategoryController";
		mapSorting();
		this.categoryService = categoryService;

	}

	private void mapSorting()
	{
		mapSorting.put("id","idCategory");
		mapSorting.put("nama","namaCategory");
	}

    @GetMapping("/v1/category/new")
    public String createCategory(Model model, WebRequest request)
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }
        model.addAttribute("category", new CategoryDTO());
        return "category/create_category";
    }

    @GetMapping("/v1/category/edit/{id}")
    public String editCategory(Model model, WebRequest request, @PathVariable("id") Long id)
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }
        objectMapper = categoryService.findById(id,request);
        CategoryDTO categoryDTO= (objectMapper.get("data")==null?null:(CategoryDTO) objectMapper.get("data"));
        if((Boolean) objectMapper.get("success"))
        {
            CategoryDTO categoryDTOForSelect = (CategoryDTO) objectMapper.get("data");
            model.addAttribute("category", categoryDTO);
            return "category/edit_category";

        }
        else
        {
            model.addAttribute("category", new CategoryDTO());
            return "redirect:/api/item/category/default";
        }
    }
    @PostMapping("/v1/category/new")
    public String newCategory(@ModelAttribute(value = "category")
                              @Valid CategoryDTO categoryDTO
            , BindingResult bindingResult
            , Model model
            , WebRequest request
    )
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }

        /* START VALIDATION */
        if(bindingResult.hasErrors())
        {
            model.addAttribute("category",categoryDTO);
            model.addAttribute("status","error");

            return "category/create_category";
        }
        Boolean isValid = true;

        if(!isValid)
        {
            model.addAttribute("category",categoryDTO);
            return "category/create_category";
        }
        /* END OF VALIDATION */

        Category category = modelMapper.map(categoryDTO, new TypeToken<Category>() {}.getType());
        objectMapper = categoryService.saveCategory(category,request);
        if(objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if((Boolean) objectMapper.get("success"))
        {
            mappingAttribute.setAttribute(model,objectMapper);
            model.addAttribute("message","DATA BERHASIL DISIMPAN");
            Long idDataSave = objectMapper.get("idDataSave")==null?1:Long.parseLong(objectMapper.get("idDataSave").toString());
            return "redirect:/api/item/v1/category/fbpsb/0/asc/idCategory?columnFirst=idCategory&valueFirst="+idDataSave+"&sizeComponent=5";//LANGSUNG DITAMPILKAN FOKUS KE HASIL EDIT USER TADI
        }
        else
        {
            mappingAttribute.setErrorMessage(bindingResult,objectMapper.get("message").toString());
            model.addAttribute("category",new CategoryDTO());
            model.addAttribute("status","error");
            return "category/create_category";
        }
    }

    @PostMapping("/v1/category/edit/{id}")
    public String doRegis(@ModelAttribute("category")
                          @Valid CategoryDTO categoryDTO
            , BindingResult bindingResult
            , Model model
            , WebRequest request
            , @PathVariable("id") Long id
    )
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }
        /* START VALIDATION */
        if(bindingResult.hasErrors())
        {
            model.addAttribute("category",categoryDTO);
            return "category/edit_category";
        }
        Boolean isValid = true;

        if(!isValid)
        {
            model.addAttribute("category",categoryDTO);

            return "categori/edit_category";
        }
        /* END OF VALIDATION */

        Category category = modelMapper.map(categoryDTO, new TypeToken<Category>() {}.getType());
        objectMapper = categoryService.updateCategory(id,category,request);
        if(objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if((Boolean) objectMapper.get("success"))
        {
            mappingAttribute.setAttribute(model,objectMapper);
            model.addAttribute("category",new CategoryDTO());
            return "redirect:/api/item/v1/category/fbpsb/0/asc/idCategory?columnFirst=idCategory&valueFirst="+id+"&sizeComponent=5";//LANGSUNG DITAMPILKAN FOKUS KE HASIL EDIT USER TADI
        }
        else
        {
            mappingAttribute.setErrorMessage(bindingResult,objectMapper.get("message").toString());
            model.addAttribute("category",new CategoryDTO());
            return "category/edit_category";
        }
    }


    @GetMapping("/v1/category/default")
    public String getDefaultData(Model model,WebRequest request)
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }
        Pageable pageable = PageRequest.of(0,5, Sort.by("idCategory"));
        objectMapper = categoryService.findAllCategory(pageable,request);
        mappingAttribute.setAttribute(model,objectMapper,request);

        model.addAttribute("category",new CategoryDTO());
        model.addAttribute("sortBy","idCategory");
        model.addAttribute("currentPage",1);
        model.addAttribute("asc","asc");
        model.addAttribute("columnFirst","");
        model.addAttribute("valueFirst","");
        model.addAttribute("sizeComponent",5);
        return "/category/category";
    }

    @GetMapping("/v1/category/fbpsb/{page}/{sort}/{sortby}")
    public String findByCategory(
            Model model,
            @PathVariable("page") Integer pagez,
            @PathVariable("sort") String sortz,
            @PathVariable("sortby") String sortzBy,
            @RequestParam String columnFirst,
            @RequestParam String valueFirst,
            @RequestParam String sizeComponent,
            WebRequest request
    ){
        sortzBy = mapSorting.get(sortzBy);
        sortzBy = sortzBy==null?"idCategory":sortzBy;
        Pageable pageable = PageRequest.of(pagez==0?pagez:pagez-1,Integer.parseInt(sizeComponent.equals("")?"5":sizeComponent), sortz.equals("asc")?Sort.by(sortzBy):Sort.by(sortzBy).descending());
        objectMapper = categoryService.findByPage(pageable,request,columnFirst,valueFirst);
        mappingAttribute.setAttribute(model,objectMapper,request);
        model.addAttribute("category",new CategoryDTO());
        model.addAttribute("currentPage",pagez==0?1:pagez);
        model.addAttribute("sortBy", ManipulationMap.getKeyFromValue(mapSorting,sortzBy));
        model.addAttribute("columnFirst",columnFirst);
        model.addAttribute("valueFirst",valueFirst);
        model.addAttribute("sizeComponent",sizeComponent);

        return "/category/category";
    }
    @GetMapping("/v1/category/delete/{id}")
    public String doRegis(Model model
            , WebRequest request
            , @PathVariable("id") Long id
    )
    {
        if(OtherConfig.getFlagSessionValidation().equals("y"))
        {
            mappingAttribute.setAttribute(model,objectMapper,request);//untuk set session
            if(request.getAttribute("USR_ID",1)==null){
                return "redirect:/api/check/logout";
            }
        }
        objectMapper = categoryService.deleteCategory(id,request);
        if(objectMapper.get("message").toString().equals(ConstantMessage.ERROR_FLOW_INVALID))//AUTO LOGOUT JIKA ADA PESAN INI
        {
            return "redirect:/api/check/logout";
        }

        if((Boolean) objectMapper.get("success"))
        {
            mappingAttribute.setAttribute(model,objectMapper);
            model.addAttribute("category",new CategoryDTO());
            return "redirect:/api/item/v1/category/fbpsb/0/asc/idCategory?columnFirst=idCategory&valueFirst="+id+"&sizeComponent=5";//LANGSUNG DITAMPILKAN FOKUS KE HASIL EDIT USER TADI
        }
        else
        {
//            mappingAttribute.setErrorMessage(bindingResult,objectMapper.get("message").toString());
            model.addAttribute("category",new CategoryDTO());
            return "/category/category";
        }
    }
	@GetMapping("/v1/category/xportpdflibre")
	public void exportToPDFLibre(
			Model model,
			@RequestParam String columnFirst,
			@RequestParam String valueFirst,
			WebRequest request,
			HttpServletResponse response
	){
		mappingAttribute.setAttribute(model,request);//untuk set session ke attribut
		List<CategoryDTO> listCategoryDTO= categoryService.dataToExport(request,columnFirst,valueFirst);
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDHHMMSS.sss");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		sBuild.setLength(0);
		String headervalue = sBuild.append("attachment; filename=categorylist").
				append(currentDateTime).append(".pdf").toString();
		response.setHeader(headerkey, headervalue);
		generator = new PdfGeneratorLibre();
		int intStrHeader=4;// INI YANG DIRUBAH SESUAIKAN DENGAN JUMLAH KOLOM
		String[] strHeader = new String[intStrHeader];
        /*
            DEFINISIKAN KOLOM NYA DISINI HARUS SESUAI JUMLAH NYA DENGAN HEADER YANG DI SET DI VARIABEL intStrHeader
         */
		strHeader[0] ="ID";
		strHeader[1] ="CATEGORY";
		int intListCategoryDTO = listCategoryDTO.size();
		strBody = new String[intListCategoryDTO][intStrHeader];

		for(int i=0;i<listCategoryDTO.size();i++)
		{
            /*
                INI KALIAN MAPPING TAPI HATI2 DENGAN OBJECT, HARUS DI HANDLE NULL NYA
             */


			strBody[i][0] = String.valueOf(listCategoryDTO.get(i).getIdCategory());
			strBody[i][1] = listCategoryDTO.get(i).getNamaCategory();

		}

		sBuild.setLength(0);
		generator.generate(sBuild.
				append("SISTEM INFORMASI PENANGANAN KELUHAN PELANGGAN \n").//JUDUL REPORT
						append("List Category                                                        Total Data : ").append(intListCategoryDTO).//VARIABEL TOTAL DATA
						toString(),strHeader,strBody, response);
	}


}
