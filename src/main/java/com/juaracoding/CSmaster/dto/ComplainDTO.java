package com.juaracoding.CSmaster.dto;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Moh. Ikhsan a.k.a. Fitriyani
Java Developer
Created on 3/19/2023 1:49 PM
@Last Modified 3/19/2023 1:49 PM
Version 1.0
*/


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.juaracoding.CSmaster.model.Category;
import com.juaracoding.CSmaster.utils.ConstantMessage;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ComplainDTO{

    @NotNull
    @NotEmpty
    @Length(message = ConstantMessage.WARNING_KODE_PRODUCT_LENGTH,max = 25)
    private String noInvoice;

    @NotNull
    @NotEmpty
    @Length(message = ConstantMessage.WARNING_PRODUCT_NAME_LENGTH,max = 200)
    private String namaProduct;

    @NotNull
    @NotEmpty
    @Length(message = ConstantMessage.WARNING_MERK_PRODUCT_LENGTH,max = 50)
    private String merkProduct;

    @NotNull
    @NotEmpty
    @Length(message = ConstantMessage.WARNING_DESCRIPTION_NAME_LENGTH,max = 500)
    private String description;

    private MultipartFile image;

    private Date createdDate = new Date();

    private Integer createdBy = 1;

    private Date modifiedDate;

    private Integer modifiedBy;

    private Byte isDelete = 1;

    private Category category;

    public String getNoInvoice() {
        return noInvoice;
    }

    public void setNoInvoice(String noInvoice) {
        this.noInvoice = noInvoice;
    }

    public String getNamaProduct() {
        return namaProduct;
    }

    public void setNamaProduct(String namaProduct) {
        this.namaProduct = namaProduct;
    }

    public String getMerkProduct() {
        return merkProduct;
    }

    public void setMerkProduct(String merkProduct) {
        this.merkProduct = merkProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
