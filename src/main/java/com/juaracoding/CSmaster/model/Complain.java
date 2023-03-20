package com.juaracoding.CSmaster.model;/*
Created By IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IU-222.4345.14, built on October 5, 2022
@Author Moh. Ikhsan a.k.a. Fitriyani
Java Developer
Created on 3/19/2023 1:44 PM
@Last Modified 3/19/2023 1:44 PM
Version 1.0
*/


import javax.persistence.*;
import java.util.Date;
import java.util.List;
import org.hibernate.annotations.GenericGenerator;
/*
    KODE MODUL 03
 */
@Entity
@Table(name = "MstComplain")
public class Complain {

    @Id
    @Column(name = " NoInvoice ", nullable = false, length = 255)
    private String noInvoice;

    @Column(name = "NamaProduct", nullable = false, length = 125)
    private String namaProduct;

    @Column(name = "MerkProduct", nullable = false, length = 50)
    private String merkProduct;

    @Column(name = "Description", nullable = false, length = 255)
    private String description;

    @Lob
    @Column(name = "Image", nullable = false, length = 255)
    private String image;

    @Column(name = "CreatedDate", nullable = false)
    private Date createdDate = new Date();

    @Column(name = "CreatedBy", nullable = false)
    private Integer createdBy = 1;

    @Column(name = "ModifiedDate")
    private Date modifiedDate;

    @Column(name = "ModifiedBy")
    private Integer modifiedBy;

    @Column(name = "IsDelete", nullable = false)
    private Byte isDelete = 1;
    /*
        end audit trails
     */

    @OneToOne
    @JoinColumn(name = "IDCategory")
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

    public String getImage() {
        return image;
    }

    @Transient
    public String getImagePath() {
        if (image == null) return null;

        return "/user-photos/" + image;
    }

    public void setImage(String image) {
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
