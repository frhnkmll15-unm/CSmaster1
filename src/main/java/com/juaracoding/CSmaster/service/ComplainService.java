package com.juaracoding.CSmaster.service;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Moh. Ikhsan a.k.a. Fitriyani
Java Developer
Created on 3/19/2023 1:42 PM
@Last Modified 3/19/2023 1:42 PM
Version 1.0
*/


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import com.juaracoding.CSmaster.configuration.OtherConfig;

import com.juaracoding.CSmaster.dto.CategoryDTO;
import com.juaracoding.CSmaster.dto.ComplainDTO;
import com.juaracoding.CSmaster.handler.ResponseHandler;

import com.juaracoding.CSmaster.model.Category;
import com.juaracoding.CSmaster.model.Complain;

import com.juaracoding.CSmaster.repo.ComplainRepo;

import com.juaracoding.CSmaster.utils.ConstantMessage;
import com.juaracoding.CSmaster.utils.LoggingFile;
import com.juaracoding.CSmaster.utils.TransformToDTO;
import org.modelmapper.ModelMapper;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;

@Service
@Transactional
public class ComplainService {
    @Autowired
    private ComplainRepo complainRepo;

    private String[] strExceptionArr = new String[2];
    @Autowired
    private ModelMapper modelMapper;

    private Map<String,Object> objectMapper = new HashMap<String,Object>();

    private TransformToDTO transformToDTO = new TransformToDTO();

    private Map<String,String> mapColumnSearch = new HashMap<String,String>();
    private Map<Integer, Integer> mapItemPerPage = new HashMap<Integer, Integer>();
    private String [] strColumnSearch = new String[2];

    public Page<Complain> findAllComplain(int pageNumber, int size)
    {
        Pageable paging = PageRequest.of(pageNumber - 1, size);

        return complainRepo.findByIsDelete(paging, (byte)1);
    }

    public Complain findComplainById(String noInvoice)
    {
        return complainRepo.findById(noInvoice).orElseThrow();
    }

    public Map<String, Object> save(Complain complain, WebRequest request) {
        String strMessage = ConstantMessage.SUCCESS_SAVE;
        Object strUserIdz = request.getAttribute("USR_ID",1);

        try {
            if(strUserIdz==null)
            {
                return new ResponseHandler().generateModelAttribut(ConstantMessage.ERROR_FLOW_INVALID,
                        HttpStatus.NOT_ACCEPTABLE,null,"FV03001",request);
            }
            complain.setCreatedBy(Integer.parseInt(strUserIdz.toString()));
            complain.setCreatedDate(new Date());

            complainRepo.save(complain);
        } catch (Exception e) {
            strExceptionArr[1] = "saveCategory(Category category, WebRequest request) --- LINE 67";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
            return new ResponseHandler().generateModelAttribut(ConstantMessage.ERROR_SAVE_FAILED,
                    HttpStatus.BAD_REQUEST,
                    transformToDTO.transformObjectDataEmpty(objectMapper,mapColumnSearch),
                    "FE03001", request);
        }
        return new ResponseHandler().generateModelAttribut(strMessage,
                HttpStatus.CREATED,
                transformToDTO.transformObjectDataSave(objectMapper, 0l,mapColumnSearch),
                null, request);
    }
	public List<ComplainDTO> dataToExport(WebRequest request, String columFirst, String valueFirst)
	{
		List<Complain> listComplain = null;
		List<ComplainDTO> listComplainDTO = null;
		Map<String,Object> mapResult = null;

		try
		{
			if(columFirst.equals("id"))
			{
				try
				{
					Long.parseLong(valueFirst);
				}
				catch (Exception e)
				{
					strExceptionArr[1] = "dataToExport(WebRequest request,String columFirst,String valueFirst) --- LINE 209";
					LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
					return new ArrayList<ComplainDTO>();
				}
			}
			listComplain = getDataToExport(columFirst,valueFirst);
			if(listComplain.size()==0)
			{
				return new ArrayList<ComplainDTO>();
			}
			 listComplainDTO = modelMapper.map(listComplain, new TypeToken<List<ComplainDTO>>() {
			}.getType());
		}

		catch (Exception e)
		{
			strExceptionArr[1] = "dataToExport(WebRequest request,String columFirst,String valueFirst) --- LINE 243";
			LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
			return new ArrayList<ComplainDTO>();
		}
		return listComplainDTO;
	}

	private List<Complain> getDataToExport(String paramColumn, String paramValue)
	{
		if(paramValue.equals(""))
		{
			return complainRepo.findByIsDelete((byte) 1);
		}
		if(paramColumn.equals("id"))
		{
			return complainRepo.findByIsDeleteAndNoInvoice((byte) 1,Long.parseLong(paramValue));
		} else if (paramColumn.equals("nama")) {
			return complainRepo.findByIsDeleteAndNamaProductContainsIgnoreCase((byte) 1,paramValue);
		}

		return complainRepo.findByIsDelete((byte) 1);
	}



    public Map<String, Object> deleteComplain(String noInvoice, WebRequest request) {
        String strMessage = ConstantMessage.SUCCESS_SAVE;
        Object strUserIdz = request.getAttribute("USR_ID",1);

        try {
            Complain nextComplain = complainRepo.findById(noInvoice).orElseThrow(
                    ()->null
            );

            if(nextComplain==null)
            {
                return new ResponseHandler().generateModelAttribut(ConstantMessage.WARNING_CATEGORY_NOT_EXISTS,
                        HttpStatus.NOT_ACCEPTABLE,
                        transformToDTO.transformObjectDataEmpty(objectMapper,mapColumnSearch),
                        "FV03002",request);
            }
            if(strUserIdz==null)
            {
                return new ResponseHandler().generateModelAttribut(ConstantMessage.ERROR_FLOW_INVALID,
                        HttpStatus.NOT_ACCEPTABLE,
                        null,
                        "FV03003",request);
            }

            nextComplain.setIsDelete((byte) 0);
            nextComplain.setModifiedBy(Integer.parseInt(strUserIdz.toString()));
            nextComplain.setModifiedDate(new Date());

        } catch (Exception e) {
            strExceptionArr[1] = "saveCategory(Category category, WebRequest request) --- LINE 67";
            LoggingFile.exceptionStringz(strExceptionArr, e, OtherConfig.getFlagLogging());
            return new ResponseHandler().generateModelAttribut(ConstantMessage.ERROR_SAVE_FAILED,
                    HttpStatus.BAD_REQUEST,
                    transformToDTO.transformObjectDataEmpty(objectMapper,mapColumnSearch),
                    "FE03001", request);
        }
        return new ResponseHandler().generateModelAttribut(strMessage,
                HttpStatus.CREATED,
                transformToDTO.transformObjectDataSave(objectMapper, 0l,mapColumnSearch),
                null, request);
    }

}
