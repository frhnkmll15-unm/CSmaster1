/*
 Navicat Premium Data Transfer

 Source Server         : fitriyani
 Source Server Type    : SQL Server
 Source Server Version : 15002000
 Source Host           :  192.168.0.75:1433
 Source Catalog        : CSmaster
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 15002000
 File Encoding         : 65001

 Date: 19/03/2023 11:36:34
*/


-- ----------------------------
-- Table structure for MapAksesMenu
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MapAksesMenu]') AND type IN ('U'))
	DROP TABLE [dbo].[MapAksesMenu]
GO

CREATE TABLE [dbo].[MapAksesMenu] (
  [IDAkses] bigint  NOT NULL,
  [IDMenu] bigint  NOT NULL
)
GO

ALTER TABLE [dbo].[MapAksesMenu] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'asdasdas',
'SCHEMA', N'dbo',
'TABLE', N'MapAksesMenu',
'COLUMN', N'IDAkses'
GO

EXEC sp_addextendedproperty
'MS_Description', N'asdasdasdasd',
'SCHEMA', N'dbo',
'TABLE', N'MapAksesMenu',
'COLUMN', N'IDMenu'
GO


-- ----------------------------
-- Records of MapAksesMenu
-- ----------------------------
INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'2')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'8')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'9')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'1', N'11')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'1')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'2')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'8')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'9')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'11')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'12')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'13')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'14')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'2', N'15')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'1')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'2')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'8')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'9')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'11')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'12')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'13')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'14')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'3', N'15')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'4', N'1')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'4', N'2')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'4', N'8')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'4', N'9')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'4', N'11')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'4', N'14')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'1')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'2')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'8')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'9')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'11')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'12')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'13')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'14')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'5', N'15')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'1')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'2')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'3')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'4')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'5')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'6')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'7')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'8')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'9')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'11')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'12')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'13')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'14')
GO

INSERT INTO [dbo].[MapAksesMenu] ([IDAkses], [IDMenu]) VALUES (N'6', N'15')
GO


-- ----------------------------
-- Table structure for MstAkses
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MstAkses]') AND type IN ('U'))
	DROP TABLE [dbo].[MstAkses]
GO

CREATE TABLE [dbo].[MstAkses] (
  [IDAkses] bigint  IDENTITY(1,1) NOT NULL,
  [CreatedBy] int  NOT NULL,
  [CreatedDate] datetime2(7)  NOT NULL,
  [IsDelete] smallint  NOT NULL,
  [ModifiedBy] int  NULL,
  [ModifiedDate] datetime2(7)  NULL,
  [NamaAkses] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [IDDivisi] bigint  NULL
)
GO

ALTER TABLE [dbo].[MstAkses] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'asdasd',
'SCHEMA', N'dbo',
'TABLE', N'MstAkses',
'COLUMN', N'IDAkses'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ads',
'SCHEMA', N'dbo',
'TABLE', N'MstAkses',
'COLUMN', N'CreatedBy'
GO

EXEC sp_addextendedproperty
'MS_Description', N'asd',
'SCHEMA', N'dbo',
'TABLE', N'MstAkses',
'COLUMN', N'CreatedDate'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ads',
'SCHEMA', N'dbo',
'TABLE', N'MstAkses',
'COLUMN', N'IsDelete'
GO

EXEC sp_addextendedproperty
'MS_Description', N'adsadsasd',
'SCHEMA', N'dbo',
'TABLE', N'MstAkses',
'COLUMN', N'ModifiedBy'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ads',
'SCHEMA', N'dbo',
'TABLE', N'MstAkses',
'COLUMN', N'ModifiedDate'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ad',
'SCHEMA', N'dbo',
'TABLE', N'MstAkses',
'COLUMN', N'NamaAkses'
GO

EXEC sp_addextendedproperty
'MS_Description', N'adsasdads',
'SCHEMA', N'dbo',
'TABLE', N'MstAkses',
'COLUMN', N'IDDivisi'
GO


-- ----------------------------
-- Records of MstAkses
-- ----------------------------
SET IDENTITY_INSERT [dbo].[MstAkses] ON
GO

INSERT INTO [dbo].[MstAkses] ([IDAkses], [CreatedBy], [CreatedDate], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaAkses], [IDDivisi]) VALUES (N'1', N'1', N'2023-03-05 07:02:58.0000000', N'1', N'9', N'2023-03-19 11:35:41.0090000', N'CUSTOMER', N'2')
GO

INSERT INTO [dbo].[MstAkses] ([IDAkses], [CreatedBy], [CreatedDate], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaAkses], [IDDivisi]) VALUES (N'2', N'1', N'2023-03-05 07:03:27.0000000', N'1', N'9', N'2023-03-19 11:35:30.3970000', N'SALES STAFF', N'2')
GO

INSERT INTO [dbo].[MstAkses] ([IDAkses], [CreatedBy], [CreatedDate], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaAkses], [IDDivisi]) VALUES (N'3', N'1', N'2023-03-05 07:03:47.0000000', N'1', N'9', N'2023-03-19 11:35:55.8370000', N'SALES MANAGER', N'2')
GO

INSERT INTO [dbo].[MstAkses] ([IDAkses], [CreatedBy], [CreatedDate], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaAkses], [IDDivisi]) VALUES (N'4', N'1', N'2023-03-05 20:07:59.0000000', N'1', N'9', N'2023-03-19 11:26:20.5080000', N'OPERATIONAL', N'3')
GO

INSERT INTO [dbo].[MstAkses] ([IDAkses], [CreatedBy], [CreatedDate], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaAkses], [IDDivisi]) VALUES (N'5', N'1', N'2023-03-05 20:21:51.0000000', N'1', N'9', N'2023-03-19 11:26:36.6640000', N'MANAGER', N'1')
GO

INSERT INTO [dbo].[MstAkses] ([IDAkses], [CreatedBy], [CreatedDate], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaAkses], [IDDivisi]) VALUES (N'6', N'1', N'2023-03-06 20:19:16.0000000', N'1', N'9', N'2023-03-19 11:36:02.9170000', N'ADMIN', N'1')
GO

SET IDENTITY_INSERT [dbo].[MstAkses] OFF
GO


-- ----------------------------
-- Table structure for MstCategory
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MstCategory]') AND type IN ('U'))
	DROP TABLE [dbo].[MstCategory]
GO

CREATE TABLE [dbo].[MstCategory] (
  [IDCategory] bigint  IDENTITY(1,1) NOT NULL,
  [CreatedBy] int  NOT NULL,
  [CreatedDate] datetime2(7)  NOT NULL,
  [IsDelete] smallint  NOT NULL,
  [ModifiedBy] int  NULL,
  [ModifiedDate] datetime2(7)  NULL,
  [NamaCategory] varchar(25) COLLATE Latin1_General_CI_AS  NOT NULL
)
GO

ALTER TABLE [dbo].[MstCategory] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of MstCategory
-- ----------------------------
SET IDENTITY_INSERT [dbo].[MstCategory] ON
GO

INSERT INTO [dbo].[MstCategory] ([IDCategory], [CreatedBy], [CreatedDate], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaCategory]) VALUES (N'1', N'9', N'2023-03-19 08:19:40.1560000', N'1', N'9', N'2023-03-19 09:11:34.5290000', N'MEJA BELAJAR')
GO

SET IDENTITY_INSERT [dbo].[MstCategory] OFF
GO


-- ----------------------------
-- Table structure for MstDivisi
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MstDivisi]') AND type IN ('U'))
	DROP TABLE [dbo].[MstDivisi]
GO

CREATE TABLE [dbo].[MstDivisi] (
  [IDDivisi] bigint  IDENTITY(1,1) NOT NULL,
  [CreatedBy] int  NOT NULL,
  [CreatedDate] datetime2(7)  NOT NULL,
  [DeskripsiDivisi] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [IsDelete] smallint  NOT NULL,
  [KodeDivisi] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [ModifiedBy] int  NULL,
  [ModifiedDate] datetime2(7)  NULL,
  [NamaDivisi] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[MstDivisi] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of MstDivisi
-- ----------------------------
SET IDENTITY_INSERT [dbo].[MstDivisi] ON
GO

INSERT INTO [dbo].[MstDivisi] ([IDDivisi], [CreatedBy], [CreatedDate], [DeskripsiDivisi], [IsDelete], [KodeDivisi], [ModifiedBy], [ModifiedDate], [NamaDivisi]) VALUES (N'1', N'1', N'2023-03-10 16:43:54.0000000', N'Divisi IT', N'1', N'IT-01', NULL, NULL, N'IT')
GO

INSERT INTO [dbo].[MstDivisi] ([IDDivisi], [CreatedBy], [CreatedDate], [DeskripsiDivisi], [IsDelete], [KodeDivisi], [ModifiedBy], [ModifiedDate], [NamaDivisi]) VALUES (N'2', N'1', N'2023-03-11 18:39:56.9350000', NULL, N'1', N'MRK-002', N'1', N'2023-03-11 18:42:23.1220000', N'MARKETING')
GO

INSERT INTO [dbo].[MstDivisi] ([IDDivisi], [CreatedBy], [CreatedDate], [DeskripsiDivisi], [IsDelete], [KodeDivisi], [ModifiedBy], [ModifiedDate], [NamaDivisi]) VALUES (N'3', N'1', N'2023-03-11 18:44:05.7360000', NULL, N'1', N'OPS - 01', N'1', N'2023-03-11 18:44:23.6560000', N'OPERASIONAL')
GO

SET IDENTITY_INSERT [dbo].[MstDivisi] OFF
GO


-- ----------------------------
-- Table structure for MstMenu
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MstMenu]') AND type IN ('U'))
	DROP TABLE [dbo].[MstMenu]
GO

CREATE TABLE [dbo].[MstMenu] (
  [IDMenu] bigint  IDENTITY(1,1) NOT NULL,
  [CreatedBy] int  NOT NULL,
  [CreatedDate] datetime2(7)  NOT NULL,
  [EndPoints] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [IsDelete] smallint  NOT NULL,
  [ModifiedBy] int  NULL,
  [ModifiedDate] datetime2(7)  NULL,
  [NamaMenu] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [PathMenu] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [IDMenuHeader] bigint  NULL
)
GO

ALTER TABLE [dbo].[MstMenu] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of MstMenu
-- ----------------------------
SET IDENTITY_INSERT [dbo].[MstMenu] ON
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'1', N'1', N'2023-03-05 06:11:12.0000000', N'localhost:8080', N'1', N'1', N'2023-03-09 04:47:29.9610000', N'CATEGORY', N'/api/item/v1/category/default', N'2')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'2', N'1', N'2023-03-05 06:11:30.0000000', N'localhost:8080', N'1', NULL, NULL, N'PRODUCT', N'/api/product/list', N'2')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'3', N'1', N'2023-03-05 06:12:27.0000000', N'localhost:8080', N'1', NULL, NULL, N'USER', N'/api/authz/v1/userman/default', N'4')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'4', N'1', N'2023-03-05 06:12:37.0000000', N'localhost:8080', N'1', NULL, NULL, N'AKSES', N'/api/usrmgmnt/v1/akses/default', N'4')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'5', N'1', N'2023-03-05 06:13:23.0000000', N'localhost:8080', N'1', N'1', N'2023-03-14 15:53:45.6700000', N'DIVISI', N'/api/usrmgmnt/v1/divisi/default', N'4')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'6', N'1', N'2023-03-05 06:13:31.0000000', N'localhost:8080', N'1', N'1', N'2023-03-14 15:51:57.0500000', N'MENU', N'/api/usrmgmnt/v1/menu/default', N'4')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'7', N'1', N'2023-03-05 06:14:09.0000000', N'localhost:8080', N'1', NULL, NULL, N'MENU HEADER', N'/api/usrmgmnt/v1/menuheader/default', N'4')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'8', N'1', N'2023-03-05 06:14:16.0000000', N'localhost:8080', N'1', NULL, NULL, N'LOKASI', N'/api/menu/hrfour', N'3')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'9', N'1', N'2023-03-05 06:14:56.0000000', N'localhost:8080', N'1', NULL, NULL, N'CONTACT  USE', N'/api/menu/financeone', N'3')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'11', N'1', N'2023-03-05 06:15:07.0000000', N'localhost:8080', N'1', NULL, NULL, N'COMPLAIN', N'/api/menu/financetwo', N'1')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'12', N'1', N'2023-03-05 06:15:41.0000000', N'localhost:8080', N'1', NULL, NULL, N'REPORT DIVISI', N'/api/menu/financethree', N'5')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'13', N'1', N'2023-03-05 06:16:07.0000000', N'localhost:8080', N'1', NULL, NULL, N'REPORT CATEGORY', N'/api/menu/financefour', N'5')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'14', N'1', N'2023-03-05 06:17:07.0000000', N'localhost:8080', N'1', NULL, NULL, N'REPORT COMPLAIN', N'/api/school/v1/students', N'5')
GO

INSERT INTO [dbo].[MstMenu] ([IDMenu], [CreatedBy], [CreatedDate], [EndPoints], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenu], [PathMenu], [IDMenuHeader]) VALUES (N'15', N'1', N'2023-03-05 06:17:37.0000000', N'localhost:8080', N'1', NULL, NULL, N'REPORT PRODUCT', N'/api/', N'5')
GO

SET IDENTITY_INSERT [dbo].[MstMenu] OFF
GO


-- ----------------------------
-- Table structure for MstMenuHeader
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MstMenuHeader]') AND type IN ('U'))
	DROP TABLE [dbo].[MstMenuHeader]
GO

CREATE TABLE [dbo].[MstMenuHeader] (
  [IDMenuHeader] bigint  IDENTITY(1,1) NOT NULL,
  [CreatedBy] int  NOT NULL,
  [CreatedDate] datetime2(7)  NOT NULL,
  [DeskripsiMenuHeader] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [IsDelete] smallint  NOT NULL,
  [ModifiedBy] int  NULL,
  [ModifiedDate] datetime2(7)  NULL,
  [NamaMenuHeader] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[MstMenuHeader] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of MstMenuHeader
-- ----------------------------
SET IDENTITY_INSERT [dbo].[MstMenuHeader] ON
GO

INSERT INTO [dbo].[MstMenuHeader] ([IDMenuHeader], [CreatedBy], [CreatedDate], [DeskripsiMenuHeader], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenuHeader]) VALUES (N'1', N'1', N'2023-03-05 06:27:25.0000000', N'YANG BERHUBUNGAN DENGAN MODUL SALES', N'1', NULL, NULL, N'SALES')
GO

INSERT INTO [dbo].[MstMenuHeader] ([IDMenuHeader], [CreatedBy], [CreatedDate], [DeskripsiMenuHeader], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenuHeader]) VALUES (N'2', N'1', N'2023-03-05 06:27:52.0000000', N'YANG BERHUBUNGAN DENGAN MODUL PRODUCT', N'1', NULL, NULL, N'PRODUCT')
GO

INSERT INTO [dbo].[MstMenuHeader] ([IDMenuHeader], [CreatedBy], [CreatedDate], [DeskripsiMenuHeader], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenuHeader]) VALUES (N'3', N'1', N'2023-03-05 06:28:00.0000000', N'YANG BERHUBUNGAN DENGAN MODUL ABOUT', N'1', NULL, NULL, N'ABOUT')
GO

INSERT INTO [dbo].[MstMenuHeader] ([IDMenuHeader], [CreatedBy], [CreatedDate], [DeskripsiMenuHeader], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenuHeader]) VALUES (N'4', N'1', N'2023-03-05 06:28:50.0000000', N'YANG BERHUBUNGAN DENGAN USER', N'1', NULL, NULL, N'USER MANAGEMENT')
GO

INSERT INTO [dbo].[MstMenuHeader] ([IDMenuHeader], [CreatedBy], [CreatedDate], [DeskripsiMenuHeader], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenuHeader]) VALUES (N'5', N'1', N'2023-03-05 06:29:11.0000000', N'YANG BERHUBUNGAN DENGAN MODUL REPORT', N'1', NULL, NULL, N'REPORT')
GO

INSERT INTO [dbo].[MstMenuHeader] ([IDMenuHeader], [CreatedBy], [CreatedDate], [DeskripsiMenuHeader], [IsDelete], [ModifiedBy], [ModifiedDate], [NamaMenuHeader]) VALUES (N'6', N'1', N'2023-03-05 06:29:26.0000000', N'UNTUK SEMUA USER', N'1', NULL, NULL, N'GLOBAL')
GO

SET IDENTITY_INSERT [dbo].[MstMenuHeader] OFF
GO


-- ----------------------------
-- Table structure for MstProduct
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MstProduct]') AND type IN ('U'))
	DROP TABLE [dbo].[MstProduct]
GO

CREATE TABLE [dbo].[MstProduct] (
  [KodeProduct] varchar(255) COLLATE Latin1_General_CI_AS  NOT NULL,
  [CreatedBy] int  NOT NULL,
  [CreatedDate] datetime2(7)  NOT NULL,
  [Description] varchar(255) COLLATE Latin1_General_CI_AS  NOT NULL,
  [Image] varchar(max) COLLATE Latin1_General_CI_AS  NOT NULL,
  [IsDelete] smallint  NOT NULL,
  [MerkProduct] varchar(50) COLLATE Latin1_General_CI_AS  NOT NULL,
  [ModifiedBy] int  NULL,
  [ModifiedDate] datetime2(7)  NULL,
  [NamaProduct] varchar(125) COLLATE Latin1_General_CI_AS  NOT NULL,
  [IDCategory] bigint  NULL
)
GO

ALTER TABLE [dbo].[MstProduct] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of MstProduct
-- ----------------------------
INSERT INTO [dbo].[MstProduct] ([KodeProduct], [CreatedBy], [CreatedDate], [Description], [Image], [IsDelete], [MerkProduct], [ModifiedBy], [ModifiedDate], [NamaProduct], [IDCategory]) VALUES (N'B0001', N'9', N'2023-03-19 08:51:28.6090000', N'MEJA SISWA1', N'19032023083957OIP.jpg', N'1', N'INNOLA1', N'9', N'2023-03-19 09:35:31.3440000', N'MEJA SISWA PRV-BK INNOLA WARNA BIRU 1', N'1')
GO


-- ----------------------------
-- Table structure for MstUser
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[MstUser]') AND type IN ('U'))
	DROP TABLE [dbo].[MstUser]
GO

CREATE TABLE [dbo].[MstUser] (
  [IDUser] bigint  IDENTITY(1,1) NOT NULL,
  [CreatedBy] int  NOT NULL,
  [CreatedDate] datetime2(7)  NOT NULL,
  [Email] varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [IsDelete] smallint  NOT NULL,
  [LastLoginDate] datetime2(7)  NULL,
  [ModifiedBy] int  NULL,
  [ModifiedDate] datetime2(7)  NULL,
  [NamaLengkap] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [NoHP] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [Password] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [PasswordCounter] int  NULL,
  [TanggalLahir] date  NULL,
  [Token] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [TokenCounter] int  NULL,
  [UserName] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [IDAkses] bigint  NULL
)
GO

ALTER TABLE [dbo].[MstUser] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'as',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'IDUser'
GO

EXEC sp_addextendedproperty
'MS_Description', N'dasda',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'CreatedBy'
GO

EXEC sp_addextendedproperty
'MS_Description', N'sdadsadsads',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'CreatedDate'
GO

EXEC sp_addextendedproperty
'MS_Description', N'asdasd',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'Email'
GO

EXEC sp_addextendedproperty
'MS_Description', N'asd',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'IsDelete'
GO

EXEC sp_addextendedproperty
'MS_Description', N'asd',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'LastLoginDate'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ads',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'ModifiedBy'
GO

EXEC sp_addextendedproperty
'MS_Description', N'asda',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'ModifiedDate'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ds',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'NamaLengkap'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ads',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'NoHP'
GO

EXEC sp_addextendedproperty
'MS_Description', N'asd',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'Password'
GO

EXEC sp_addextendedproperty
'MS_Description', N'a',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'PasswordCounter'
GO

EXEC sp_addextendedproperty
'MS_Description', N'dsa',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'TanggalLahir'
GO

EXEC sp_addextendedproperty
'MS_Description', N'sd',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'Token'
GO

EXEC sp_addextendedproperty
'MS_Description', N'asd',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'TokenCounter'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ads',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'UserName'
GO

EXEC sp_addextendedproperty
'MS_Description', N'ads',
'SCHEMA', N'dbo',
'TABLE', N'MstUser',
'COLUMN', N'IDAkses'
GO


-- ----------------------------
-- Records of MstUser
-- ----------------------------
SET IDENTITY_INSERT [dbo].[MstUser] ON
GO

INSERT INTO [dbo].[MstUser] ([IDUser], [CreatedBy], [CreatedDate], [Email], [IsDelete], [LastLoginDate], [ModifiedBy], [ModifiedDate], [NamaLengkap], [NoHP], [Password], [PasswordCounter], [TanggalLahir], [Token], [TokenCounter], [UserName], [IDAkses]) VALUES (N'1', N'9', N'2023-03-19 10:09:04.9660000', N'rahmat@gmail.com', N'1', N'2023-03-15 21:05:56.9080000', N'1', N'2023-03-12 20:24:55.4540000', N'Rahmat Hidayat', N'+62130872772', N'$2a$11$7aA58GlxcrURzGq1yZZC0Om74y/rdfxwbCymkzjKep2fPbm8S5RIK', N'0', N'2007-12-25', N'$2a$11$waC2wiqeOA2zX9Eqhzahv.M3SPubsaFsssZCYWgdkHKYxOCrWOmBK', N'0', N'rahmat123456', N'1')
GO

INSERT INTO [dbo].[MstUser] ([IDUser], [CreatedBy], [CreatedDate], [Email], [IsDelete], [LastLoginDate], [ModifiedBy], [ModifiedDate], [NamaLengkap], [NoHP], [Password], [PasswordCounter], [TanggalLahir], [Token], [TokenCounter], [UserName], [IDAkses]) VALUES (N'2', N'9', N'2023-03-19 10:09:59.5190000', N'puspa@gmail.com', N'1', N'2023-03-05 21:50:55.8250000', NULL, NULL, N'Puspa Rina', N'+62893883833', N'$2a$11$08v.M44DWTy9uSo9x5/9GOLlJiua8YzvFcuo0DGHmhMYHECBUSJW2', N'0', N'1992-12-25', N'$2a$11$9agNZojnokeKX4sKPafOw.tCK.xX7Nk6iiSgbKxDR0qScif1pxQQ.', N'0', N'puspa12345', N'2')
GO

INSERT INTO [dbo].[MstUser] ([IDUser], [CreatedBy], [CreatedDate], [Email], [IsDelete], [LastLoginDate], [ModifiedBy], [ModifiedDate], [NamaLengkap], [NoHP], [Password], [PasswordCounter], [TanggalLahir], [Token], [TokenCounter], [UserName], [IDAkses]) VALUES (N'3', N'9', N'2023-03-19 10:11:47.7100000', N'intan@gmail.com', N'1', N'2023-03-07 20:20:24.1890000', NULL, NULL, N'Intan Rahmanita', N'+6283636622', N'$2a$11$cFsdlEPp9/N8yVv2b884j.Z8S0JzsDwzLDA2kc6AZagCQ55KmpqHK', N'0', N'1993-11-25', N'$2a$11$MZnZGrOW2UAv1DDs57lPoOs8KNzD7rqDNa00ZSy06OslwlX7vqWFG', N'0', N'intan123456', N'3')
GO

INSERT INTO [dbo].[MstUser] ([IDUser], [CreatedBy], [CreatedDate], [Email], [IsDelete], [LastLoginDate], [ModifiedBy], [ModifiedDate], [NamaLengkap], [NoHP], [Password], [PasswordCounter], [TanggalLahir], [Token], [TokenCounter], [UserName], [IDAkses]) VALUES (N'9', N'9', N'2023-03-19 10:12:27.8930000', N'fitriyani07071@gmail.com', N'1', N'2023-03-19 11:34:56.4400000', N'9', N'2023-03-19 07:08:22.7160000', N'Fitriyani', N'+6281324171', N'$2a$11$faKZtsfSTPB7YwaEYVOI4./kVYZsmamF/45nrbj.XBceQZInk26/K', N'0', N'1999-12-12', N'$2a$11$9vc5QSeR2K3UbYrgpHzxLOE34/2kgQ2lV91YoMTFUl4h.3Q7P2G1C', N'0', N'fitriyani07071', N'6')
GO

INSERT INTO [dbo].[MstUser] ([IDUser], [CreatedBy], [CreatedDate], [Email], [IsDelete], [LastLoginDate], [ModifiedBy], [ModifiedDate], [NamaLengkap], [NoHP], [Password], [PasswordCounter], [TanggalLahir], [Token], [TokenCounter], [UserName], [IDAkses]) VALUES (N'11', N'9', N'2023-03-19 10:13:28.5050000', N'frhn.kmll15@gmail.com', N'1', N'2023-03-14 16:58:28.1900000', N'11', N'2023-03-14 16:49:52.7130000', N'Muhammad Farhan', N'+62813241718', N'$2a$11$kDFXQR6Zvqz61J0fzmNhWe5Ba6EGjPJ88C7YrPjwRqT.Cbodc928u', N'0', N'1999-01-12', N'$2a$11$dptK.onHPvSGJQHzi3rHyOdPaEuw76.7./lATWcJECvyqZKW.BAZu', N'0', N'frhn.kml1234', N'6')
GO

INSERT INTO [dbo].[MstUser] ([IDUser], [CreatedBy], [CreatedDate], [Email], [IsDelete], [LastLoginDate], [ModifiedBy], [ModifiedDate], [NamaLengkap], [NoHP], [Password], [PasswordCounter], [TanggalLahir], [Token], [TokenCounter], [UserName], [IDAkses]) VALUES (N'26', N'9', N'2023-03-19 10:14:23.4530000', N'kevin123@gmail.com', N'1', N'2023-03-15 01:36:37.8720000', N'26', N'2023-03-15 01:35:31.6300000', N'Kevin Sillahi', N'+628132417134', N'$2a$11$vCdwEc59k1cOeJNtzJuGRuU5c3kPZz3lpvbyL7N4KVPz7MMGeYll2', N'0', N'1992-12-12', N'$2a$11$3N2wtV36h6bSoXnQF6mr/uY8QP/rvAlNyZF2k4V62Z5CQ8VQeKbcO', N'0', N'kevin123456', N'1')
GO

INSERT INTO [dbo].[MstUser] ([IDUser], [CreatedBy], [CreatedDate], [Email], [IsDelete], [LastLoginDate], [ModifiedBy], [ModifiedDate], [NamaLengkap], [NoHP], [Password], [PasswordCounter], [TanggalLahir], [Token], [TokenCounter], [UserName], [IDAkses]) VALUES (N'28', N'9', N'2023-03-19 10:15:17.8580000', N'ryantama@gmail.com', N'1', N'2023-03-15 21:08:17.7540000', N'28', N'2023-03-15 21:08:06.9120000', N'Ryantama Putra', N'+62813241712', N'$2a$11$QBVbwDE/xwUHwhxrif6kTeK9gdJkoVYUP4Eri9gYOVMhBh/cjtqTS', N'0', N'1999-01-12', N'835659', N'0', N'ryantama123', N'4')
GO

INSERT INTO [dbo].[MstUser] ([IDUser], [CreatedBy], [CreatedDate], [Email], [IsDelete], [LastLoginDate], [ModifiedBy], [ModifiedDate], [NamaLengkap], [NoHP], [Password], [PasswordCounter], [TanggalLahir], [Token], [TokenCounter], [UserName], [IDAkses]) VALUES (N'29', N'9', N'2023-03-19 10:15:54.5370000', N'12191238@bsi.ac.id', N'1', N'2023-03-16 11:51:15.0130000', NULL, NULL, N'Salsabillah', N'+6289687744', N'$2a$11$mFeEmCQMKVbdiiHm98NSZuKvUdaR/BqSnhT.EALuPKMz1GEYWlZl2', N'0', N'2000-07-01', N'$2a$11$2VQzUtyZ3QguuntelGly4ec21AQ7kBcfDq34FRs4k4rjUkO8EkQCq', N'0', N'slsbllh012345', N'5')
GO

SET IDENTITY_INSERT [dbo].[MstUser] OFF
GO


-- ----------------------------
-- Table structure for SPRING_SESSION
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[SPRING_SESSION]') AND type IN ('U'))
	DROP TABLE [dbo].[SPRING_SESSION]
GO

CREATE TABLE [dbo].[SPRING_SESSION] (
  [PRIMARY_ID] char(36) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [SESSION_ID] char(36) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [CREATION_TIME] bigint  NOT NULL,
  [LAST_ACCESS_TIME] bigint  NOT NULL,
  [MAX_INACTIVE_INTERVAL] int  NOT NULL,
  [EXPIRY_TIME] bigint  NOT NULL,
  [PRINCIPAL_NAME] varchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[SPRING_SESSION] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of SPRING_SESSION
-- ----------------------------
INSERT INTO [dbo].[SPRING_SESSION] ([PRIMARY_ID], [SESSION_ID], [CREATION_TIME], [LAST_ACCESS_TIME], [MAX_INACTIVE_INTERVAL], [EXPIRY_TIME], [PRINCIPAL_NAME]) VALUES (N'1f08fc8b-ad4e-41f0-9ee1-d48c0a095075', N'f5075049-1b30-4d19-b900-6bd90779cab2', N'1679200496493', N'1679200572417', N'1800', N'1679202372417', NULL)
GO


-- ----------------------------
-- Table structure for SPRING_SESSION_ATTRIBUTES
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[SPRING_SESSION_ATTRIBUTES]') AND type IN ('U'))
	DROP TABLE [dbo].[SPRING_SESSION_ATTRIBUTES]
GO

CREATE TABLE [dbo].[SPRING_SESSION_ATTRIBUTES] (
  [SESSION_PRIMARY_ID] char(36) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [ATTRIBUTE_NAME] varchar(200) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [ATTRIBUTE_BYTES] image  NOT NULL
)
GO

ALTER TABLE [dbo].[SPRING_SESSION_ATTRIBUTES] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of SPRING_SESSION_ATTRIBUTES
-- ----------------------------
INSERT INTO [dbo].[SPRING_SESSION_ATTRIBUTES] ([SESSION_PRIMARY_ID], [ATTRIBUTE_NAME], [ATTRIBUTE_BYTES]) VALUES (N'1f08fc8b-ad4e-41f0-9ee1-d48c0a095075', N'EMAIL', 0xACED0005740018666974726979616E69303730373140676D61696C2E636F6D)
GO

INSERT INTO [dbo].[SPRING_SESSION_ATTRIBUTES] ([SESSION_PRIMARY_ID], [ATTRIBUTE_NAME], [ATTRIBUTE_BYTES]) VALUES (N'1f08fc8b-ad4e-41f0-9ee1-d48c0a095075', N'HTML_MENU', 0xACED00057404553C6C693E3C6120687265663D2223223E50524F445543543C2F613E3C756C20636C6173733D226D656E752D64726F70646F776E223E3C6C693E3C6120687265663D222F6170692F6974656D2F76312F63617465676F72792F64656661756C74223E43415445474F52593C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F70726F647563742F6C697374223E50524F445543543C2F613E3C2F6C693E3C2F756C3E3C2F6C693E3C6C693E3C6120687265663D2223223E55534552204D414E4147454D454E543C2F613E3C756C20636C6173733D226D656E752D64726F70646F776E223E3C6C693E3C6120687265663D222F6170692F617574687A2F76312F757365726D616E2F64656661756C74223E555345523C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F7573726D676D6E742F76312F616B7365732F64656661756C74223E414B5345533C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F7573726D676D6E742F76312F6469766973692F64656661756C74223E4449564953493C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F7573726D676D6E742F76312F6D656E752F64656661756C74223E4D454E553C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F7573726D676D6E742F76312F6D656E756865616465722F64656661756C74223E4D454E55204845414445523C2F613E3C2F6C693E3C2F756C3E3C2F6C693E3C6C693E3C6120687265663D2223223E5245504F52543C2F613E3C756C20636C6173733D226D656E752D64726F70646F776E223E3C6C693E3C6120687265663D222F6170692F6D656E752F66696E616E63657468726565223E5245504F5254204449564953493C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F6D656E752F66696E616E6365666F7572223E5245504F52542043415445474F52593C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F7363686F6F6C2F76312F73747564656E7473223E5245504F525420434F4D504C41494E3C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F223E5245504F52542050524F445543543C2F613E3C2F6C693E3C2F756C3E3C2F6C693E3C6C693E3C6120687265663D2223223E53414C45533C2F613E3C756C20636C6173733D226D656E752D64726F70646F776E223E3C6C693E3C6120687265663D222F6170692F6D656E752F66696E616E636574776F223E434F4D504C41494E3C2F613E3C2F6C693E3C2F756C3E3C2F6C693E3C6C693E3C6120687265663D2223223E41424F55543C2F613E3C756C20636C6173733D226D656E752D64726F70646F776E223E3C6C693E3C6120687265663D222F6170692F6D656E752F6872666F7572223E4C4F4B4153493C2F613E3C2F6C693E3C6C693E3C6120687265663D222F6170692F6D656E752F66696E616E63656F6E65223E434F4E5441435420205553453C2F613E3C2F6C693E3C2F756C3E3C2F6C693E)
GO

INSERT INTO [dbo].[SPRING_SESSION_ATTRIBUTES] ([SESSION_PRIMARY_ID], [ATTRIBUTE_NAME], [ATTRIBUTE_BYTES]) VALUES (N'1f08fc8b-ad4e-41f0-9ee1-d48c0a095075', N'NO_HP', 0xACED000574000B2B36323831333234313731)
GO

INSERT INTO [dbo].[SPRING_SESSION_ATTRIBUTES] ([SESSION_PRIMARY_ID], [ATTRIBUTE_NAME], [ATTRIBUTE_BYTES]) VALUES (N'1f08fc8b-ad4e-41f0-9ee1-d48c0a095075', N'USR_ID', 0xACED00057372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000009)
GO

INSERT INTO [dbo].[SPRING_SESSION_ATTRIBUTES] ([SESSION_PRIMARY_ID], [ATTRIBUTE_NAME], [ATTRIBUTE_BYTES]) VALUES (N'1f08fc8b-ad4e-41f0-9ee1-d48c0a095075', N'USR_NAME', 0xACED000574000E666974726979616E693037303731)
GO


-- ----------------------------
-- Uniques structure for table MapAksesMenu
-- ----------------------------
ALTER TABLE [dbo].[MapAksesMenu] ADD CONSTRAINT [UK61m8nb84ts4aymf0adi0hngv5] UNIQUE NONCLUSTERED ([IDAkses] ASC, [IDMenu] ASC)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for MstAkses
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[MstAkses]', RESEED, 16)
GO


-- ----------------------------
-- Primary Key structure for table MstAkses
-- ----------------------------
ALTER TABLE [dbo].[MstAkses] ADD CONSTRAINT [PK__MstAkses__54B7D338EC9D3740] PRIMARY KEY CLUSTERED ([IDAkses])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for MstCategory
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[MstCategory]', RESEED, 1)
GO


-- ----------------------------
-- Primary Key structure for table MstCategory
-- ----------------------------
ALTER TABLE [dbo].[MstCategory] ADD CONSTRAINT [PK__MstCateg__1AA1EC667A702598] PRIMARY KEY CLUSTERED ([IDCategory])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for MstDivisi
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[MstDivisi]', RESEED, 11)
GO


-- ----------------------------
-- Primary Key structure for table MstDivisi
-- ----------------------------
ALTER TABLE [dbo].[MstDivisi] ADD CONSTRAINT [PK__MstDivis__DF97AFD6C3E8676C] PRIMARY KEY CLUSTERED ([IDDivisi])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for MstMenu
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[MstMenu]', RESEED, 65)
GO


-- ----------------------------
-- Primary Key structure for table MstMenu
-- ----------------------------
ALTER TABLE [dbo].[MstMenu] ADD CONSTRAINT [PK__MstMenu__089D3C2227882BA8] PRIMARY KEY CLUSTERED ([IDMenu])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for MstMenuHeader
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[MstMenuHeader]', RESEED, 6)
GO


-- ----------------------------
-- Primary Key structure for table MstMenuHeader
-- ----------------------------
ALTER TABLE [dbo].[MstMenuHeader] ADD CONSTRAINT [PK__MstMenuH__37AECB62E5A268B3] PRIMARY KEY CLUSTERED ([IDMenuHeader])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table MstProduct
-- ----------------------------
ALTER TABLE [dbo].[MstProduct] ADD CONSTRAINT [PK__MstProdu__0D4537815B129184] PRIMARY KEY CLUSTERED ([KodeProduct])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for MstUser
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[MstUser]', RESEED, 29)
GO


-- ----------------------------
-- Uniques structure for table MstUser
-- ----------------------------
ALTER TABLE [dbo].[MstUser] ADD CONSTRAINT [UK_oboap7j0f37yn6as1f4bdg8ge] UNIQUE NONCLUSTERED ([Email] ASC)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

ALTER TABLE [dbo].[MstUser] ADD CONSTRAINT [UKoboap7j0f37yn6as1f4bdg8ge] UNIQUE NONCLUSTERED ([Email] ASC)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table MstUser
-- ----------------------------
ALTER TABLE [dbo].[MstUser] ADD CONSTRAINT [PK__MstUser__EAE6D9DF2CE37520] PRIMARY KEY CLUSTERED ([IDUser])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Indexes structure for table SPRING_SESSION
-- ----------------------------
CREATE UNIQUE NONCLUSTERED INDEX [SPRING_SESSION_IX1]
ON [dbo].[SPRING_SESSION] (
  [SESSION_ID] ASC
)
GO

CREATE NONCLUSTERED INDEX [SPRING_SESSION_IX2]
ON [dbo].[SPRING_SESSION] (
  [EXPIRY_TIME] ASC
)
GO

CREATE NONCLUSTERED INDEX [SPRING_SESSION_IX3]
ON [dbo].[SPRING_SESSION] (
  [PRINCIPAL_NAME] ASC
)
GO


-- ----------------------------
-- Primary Key structure for table SPRING_SESSION
-- ----------------------------
ALTER TABLE [dbo].[SPRING_SESSION] ADD CONSTRAINT [SPRING_SESSION_PK] PRIMARY KEY CLUSTERED ([PRIMARY_ID])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table SPRING_SESSION_ATTRIBUTES
-- ----------------------------
ALTER TABLE [dbo].[SPRING_SESSION_ATTRIBUTES] ADD CONSTRAINT [SPRING_SESSION_ATTRIBUTES_PK] PRIMARY KEY CLUSTERED ([SESSION_PRIMARY_ID], [ATTRIBUTE_NAME])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Foreign Keys structure for table MapAksesMenu
-- ----------------------------
ALTER TABLE [dbo].[MapAksesMenu] ADD CONSTRAINT [FKutfr2432txflhxixc2xot0cm] FOREIGN KEY ([IDMenu]) REFERENCES [dbo].[MstMenu] ([IDMenu]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO

ALTER TABLE [dbo].[MapAksesMenu] ADD CONSTRAINT [FKia1giko3k3ge4a2kcikjxkpyg] FOREIGN KEY ([IDAkses]) REFERENCES [dbo].[MstAkses] ([IDAkses]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table MstAkses
-- ----------------------------
ALTER TABLE [dbo].[MstAkses] ADD CONSTRAINT [FKgxejoj2u42dx4cgikmx46n21u] FOREIGN KEY ([IDDivisi]) REFERENCES [dbo].[MstDivisi] ([IDDivisi]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table MstMenu
-- ----------------------------
ALTER TABLE [dbo].[MstMenu] ADD CONSTRAINT [FKj5kkux3pyvhfpewo2v2f5ei83] FOREIGN KEY ([IDMenuHeader]) REFERENCES [dbo].[MstMenuHeader] ([IDMenuHeader]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table MstProduct
-- ----------------------------
ALTER TABLE [dbo].[MstProduct] ADD CONSTRAINT [FK5ikg751mqus0tkp01sp7mknvx] FOREIGN KEY ([IDCategory]) REFERENCES [dbo].[MstCategory] ([IDCategory]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table MstUser
-- ----------------------------
ALTER TABLE [dbo].[MstUser] ADD CONSTRAINT [FKcciji28beqoqu0c84msjgwa07] FOREIGN KEY ([IDAkses]) REFERENCES [dbo].[MstAkses] ([IDAkses]) ON DELETE NO ACTION ON UPDATE NO ACTION
GO


-- ----------------------------
-- Foreign Keys structure for table SPRING_SESSION_ATTRIBUTES
-- ----------------------------
ALTER TABLE [dbo].[SPRING_SESSION_ATTRIBUTES] ADD CONSTRAINT [SPRING_SESSION_ATTRIBUTES_FK] FOREIGN KEY ([SESSION_PRIMARY_ID]) REFERENCES [dbo].[SPRING_SESSION] ([PRIMARY_ID]) ON DELETE CASCADE ON UPDATE NO ACTION
GO

