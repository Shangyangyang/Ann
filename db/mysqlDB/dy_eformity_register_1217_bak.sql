/*
Navicat SQL Server Data Transfer

Source Server         : 济南正式
Source Server Version : 110000
Source Host           : 172.18.221.18:1433
Source Database       : jncl_center
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 110000
File Encoding         : 65001

Date: 2020-12-17 09:46:38
*/


-- ----------------------------
-- Table structure for dy_eformity_register
-- ----------------------------
DROP TABLE [dbo].[dy_eformity_register]
GO
CREATE TABLE [dbo].[dy_eformity_register] (
[ID] char(32) NOT NULL ,
[G200] varchar(32) NULL ,
[G205] varchar(16) NULL ,
[G206] nvarchar(64) NULL ,
[G1] nvarchar(32) NULL ,
[O14] int NULL ,
[O15] varchar(8) NULL ,
[O16] varchar(8) NULL ,
[G207] varchar(32) NULL ,
[O17] varchar(18) NULL ,
[O18] varchar(8) NULL ,
[O19] datetime NULL ,
[O20] varchar(8) NULL ,
[G2] varchar(32) NULL ,
[G3] varchar(8) NULL ,
[G4] varchar(8) NULL ,
[O1] varchar(8) NULL ,
[O2] varchar(32) NULL ,
[G7] varchar(8) NULL ,
[G9] varchar(8) NULL ,
[G11] varchar(8) NULL ,
[O3] varchar(8) NULL ,
[G37] varchar(8) NULL ,
[G8] varchar(8) NULL ,
[G10] varchar(8) NULL ,
[G12] varchar(8) NULL ,
[G13] varchar(8) NULL ,
[G14] varchar(8) NULL ,
[G14_A] varchar(8) NULL ,
[G14_B] varchar(8) NULL ,
[G15] varchar(8) NULL ,
[G16] varchar(8) NULL ,
[G17] varchar(8) NULL ,
[G18] varchar(8) NULL ,
[G19] varchar(8) NULL ,
[G20_A] varchar(8) NULL ,
[G20_B] varchar(64) NULL ,
[G22_A] varchar(8) NULL ,
[G22_B] varchar(32) NULL ,
[G23] varchar(8) NULL ,
[G24] varchar(8) NULL ,
[G25] varchar(8) NULL ,
[G26] varchar(8) NULL ,
[G27_A] varchar(8) NULL ,
[G27_B] varchar(32) NULL ,
[G28_A] varchar(8) NULL ,
[G28_B] varchar(32) NULL ,
[G29] varchar(8) NULL ,
[G31] varchar(8) NULL ,
[G32] varchar(8) NULL ,
[G33] varchar(64) NULL ,
[G34_A] varchar(8) NULL ,
[G34_B] varchar(64) NULL ,
[G35] varchar(64) NULL ,
[G39] varchar(8) NULL ,
[G40] varchar(64) NULL ,
[G36] varchar(8) NULL ,
[O4] varchar(64) NULL ,
[O5] varchar(128) NULL ,
[O6] varchar(128) NULL ,
[O22] varchar(32) NULL ,
[O7] varchar(128) NULL ,
[O10] varchar(8) NULL ,
[O10_A] varchar(8) NULL ,
[O10_B] varchar(8) NULL ,
[O10_C] varchar(8) NULL ,
[O10_D] varchar(8) NULL ,
[O11_A] varchar(8) NULL ,
[O11_B] varchar(128) NULL ,
[O11_C] varchar(16) NULL ,
[O12_A] varchar(8) NULL ,
[O12_B] varchar(256) NULL ,
[G30_A] varchar(8) NULL ,
[G30_B] varchar(8) NULL ,
[G38_A] varchar(8) NULL ,
[G38_B] varchar(256) NULL ,
[O13_A] varchar(8) NULL ,
[O13_B] varchar(128) NULL ,
[G203] nvarchar(32) NULL ,
[G5] nvarchar(32) NULL ,
[G6_A] varchar(32) NULL ,
[G6_B] varchar(32) NULL ,
[G201] nvarchar(32) NULL ,
[O21] varchar(32) NULL ,
[G202] date NULL ,
[HUKOU_NUM] varchar(32) NULL ,
[MORE_NUM] varchar(32) NULL ,
[RESEARCH_METHOD] varchar(2) NULL ,
[CHECK_STATE] varchar(2) NULL ,
[ODATA_RESOURSE] varchar(2) NULL ,
[REPORT_X] varchar(64) NULL ,
[REPORT_Y] varchar(64) NULL ,
[report_name] nvarchar(256) NULL ,
[create_date] datetime NULL ,
[del_flag] varchar(1) NULL ,
[update_date] datetime NULL ,
[ext1] varchar(32) NULL ,
[ext2] varchar(32) NULL ,
[POORMAN] varchar(32) NULL ,
[ext4] varchar(32) NULL ,
[ext5] varchar(128) NULL ,
[ext6] varchar(32) NULL ,
[ext7] varchar(32) NULL ,
[ext8] varchar(32) NULL ,
[ext9] varchar(256) NULL ,
[ext10] nvarchar(2000) NULL ,
[INPUT_DATE] datetime NULL ,
[niandu] varchar(4) NULL ,
[LUOSHI_STATE] varchar(4) NULL ,
[edu_state] varchar(8) NULL DEFAULT ((0)) 
)


GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'ID')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ID'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'ID'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ID'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G200')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'所属机构编码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G200'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'所属机构编码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G200'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G205')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'调查批次'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G205'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'调查批次'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G205'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G206')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'现居住地址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G206'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'现居住地址'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G206'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G1')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾人姓名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G1'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾人姓名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G1'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O14')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾人年龄'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O14'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾人年龄'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O14'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O15')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾类别'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O15'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾类别'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O15'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O16')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾等级'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O16'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾等级'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O16'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G207')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾等级字符串'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G207'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾等级字符串'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G207'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O17')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾人身份证号'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O17'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾人身份证号'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O17'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O18')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾人性别'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O18'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾人性别'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O18'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O19')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾人出生日期'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O19'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾人出生日期'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O19'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O20')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'证件类型'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O20'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'证件类型'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O20'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G2')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾人证号'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G2'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾人证号'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G2'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G3')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'户口性质'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G3'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'户口性质'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G3'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G4')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'婚姻情况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G4'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'婚姻情况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G4'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O1')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'致残原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O1'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'致残原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O1'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O2')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'生活自理'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O2'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'生活自理'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O2'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G7')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'在敬（养）老院、福利院、荣军院等居住'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G7'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'在敬（养）老院、福利院、荣军院等居住'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G7'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G9')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'非农业户口住房状况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G9'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'非农业户口住房状况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G9'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G11')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'农业户口住房状况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G11'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'农业户口住房状况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G11'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O3')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'农业户口自有住房情况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O3'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'农业户口自有住房情况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O3'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G37')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'家庭无障碍改造'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G37'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'家庭无障碍改造'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G37'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G8')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'非农业户口家庭收入'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G8'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'非农业户口家庭收入'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G8'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G10')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'农业户口家庭收入'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G10'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'农业户口家庭收入'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G10'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G12')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否识字（1 是；2 否）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G12'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否识字（1 是；2 否）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G12'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G13')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'最高学历（1未上学;2小学;3初中;4高中（中专）;5大专;6本科;7研究生）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G13'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'最高学历（1未上学;2小学;3初中;4高中（中专）;5大专;6本科;7研究生）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G13'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G14')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'就读学校类型'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G14'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'就读学校类型'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G14'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G14_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'普通教育机构'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G14_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'普通教育机构'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G14_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G14_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'特殊教育机构'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G14_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'特殊教育机构'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G14_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G15')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'未入学原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G15'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'未入学原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G15'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G16')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否就业（_1就业;_2未就业）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G16'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否就业（_1就业;_2未就业）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G16'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G17')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'就业状况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G17'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'就业状况'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G17'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G18')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'未就业主要生活来源（_1退休金（养老金）;_2财产性收入;_3社会救助与社会福利;_4家庭成员供养;_5其他; ）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G18'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'未就业主要生活来源（_1退休金（养老金）;_2财产性收入;_3社会救助与社会福利;_4家庭成员供养;_5其他; ）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G18'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G19')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'未就业主要原因（_1在校学习;_2退休;_3丧失劳动能力;_4无就业意愿;_5无就业技能;_6农用土地被征用;_7其他）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G19'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'未就业主要原因（_1在校学习;_2退休;_3丧失劳动能力;_4无就业意愿;_5无就业技能;_6农用土地被征用;_7其他）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G19'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G20_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'一年内是否获得帮扶'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G20_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'一年内是否获得帮扶'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G20_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G20_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'一年内获得帮扶项目'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G20_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'一年内获得帮扶项目'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G20_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G22_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否有职工社会保险'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G22_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否有职工社会保险'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G22_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G22_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'缴纳职工社会保险项
G22B_1养老保险;G22B_2医疗保险;G22B_3其他保险（失业保险、工伤保险、生育保险）;G22A_4未参加
'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G22_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'缴纳职工社会保险项
G22B_1养老保险;G22B_2医疗保险;G22B_3其他保险（失业保险、工伤保险、生育保险）;G22A_4未参加
'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G22_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G23')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否有居民养老保险'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G23'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否有居民养老保险'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G23'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G24')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否享受居民养老保险缴费补贴'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G24'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否享受居民养老保险缴费补贴'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G24'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G25')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否有居民医疗保险'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G25'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否有居民医疗保险'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G25'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G26')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否享受居民医疗保险缴费补贴'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G26'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否享受居民医疗保险缴费补贴'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G26'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G27_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否有社会救助'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G27_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否有社会救助'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G27_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G27_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'得到社会救助项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G27_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'得到社会救助项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G27_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G28_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否享受社会福利'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G28_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否享受社会福利'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G28_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G28_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'享受社会福利项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G28_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'享受社会福利项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G28_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G29')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'托养服务'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G29'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'托养服务'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G29'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G31')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'过去两周是否患有其他疾病'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G31'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'过去两周是否患有其他疾病'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G31'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G32')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'患病是否就诊'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G32'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'患病是否就诊'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G32'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G33')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'未就诊原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G33'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'未就诊原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G33'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G34_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否得到过康复治疗'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G34_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否得到过康复治疗'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G34_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G34_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'使用康复治疗方式'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G34_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'使用康复治疗方式'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G34_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G35')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'未得到康复治疗原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G35'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'未得到康复治疗原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G35'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G39')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否参加文体活动'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G39'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否参加文体活动'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G39'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G40')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'很少参加文体活动原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G40'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'很少参加文体活动原因'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G40'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G36')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否需要康复服务'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G36'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否需要康复服务'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G36'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O4')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'康复服务手术治疗项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O4'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'康复服务手术治疗项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O4'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O5')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'康复服务功能训练项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O5'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'康复服务功能训练项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O5'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O6')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'康复服务辅助器具项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O6'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'康复服务辅助器具项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O6'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O22')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'假肢（上肢、小腿、大腿）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O22'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'假肢（上肢、小腿、大腿）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O22'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O7')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'其他康复项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O7'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'其他康复项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O7'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O10')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'教育类型'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'教育类型'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O10_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否需要教育'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否需要教育'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O10_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'义务教育'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'义务教育'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O10_C')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'高中及以上教育'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10_C'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'高中及以上教育'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10_C'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O10_D')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'教育资金资助'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10_D'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'教育资金资助'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O10_D'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O11_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否需要就业'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O11_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否需要就业'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O11_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O11_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'需要就业扶持项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O11_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'需要就业扶持项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O11_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O11_C')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'需要就业职业指导项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O11_C'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'需要就业职业指导项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O11_C'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O12_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否需要培训'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O12_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否需要培训'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O12_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O12_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'需要培训项目'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O12_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'需要培训项目'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O12_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G30_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否需要托养需求'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G30_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否需要托养需求'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G30_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G30_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'托养需求项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G30_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'托养需求项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G30_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G38_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否需要家庭无障碍改造'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G38_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否需要家庭无障碍改造'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G38_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G38_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'需要家庭无障碍改造项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G38_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'需要家庭无障碍改造项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G38_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O13_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'是否需要体育活动  体育活动无需求'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O13_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'是否需要体育活动  体育活动无需求'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O13_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O13_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'需要的文体活动项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O13_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'需要的文体活动项'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O13_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G203')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'残疾人签字（申报人）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G203'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'残疾人签字（申报人）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G203'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G5')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'联系人姓名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G5'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'联系人姓名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G5'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G6_A')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'联系人固话'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G6_A'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'联系人固话'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G6_A'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G6_B')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'联系人手机'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G6_B'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'联系人手机'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G6_B'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G201')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'调查员姓名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G201'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'调查员姓名'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G201'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'O21')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'调查员联系电话'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O21'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'调查员联系电话'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'O21'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'G202')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'填表日期'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G202'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'填表日期'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'G202'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'HUKOU_NUM')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'户口号码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'HUKOU_NUM'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'户口号码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'HUKOU_NUM'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'MORE_NUM')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'一户多残编码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'MORE_NUM'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'一户多残编码'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'MORE_NUM'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'RESEARCH_METHOD')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'调查方式'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'RESEARCH_METHOD'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'调查方式'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'RESEARCH_METHOD'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'CHECK_STATE')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'核查状态'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'CHECK_STATE'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'核查状态'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'CHECK_STATE'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'ODATA_RESOURSE')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'数据来源'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ODATA_RESOURSE'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'数据来源'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ODATA_RESOURSE'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'REPORT_X')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'上报位置经度'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'REPORT_X'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'上报位置经度'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'REPORT_X'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'REPORT_Y')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'上报位置纬度'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'REPORT_Y'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'上报位置纬度'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'REPORT_Y'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'report_name')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'上报位置名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'report_name'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'上报位置名称'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'report_name'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'ext5')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'需求_文体（艺术）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ext5'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'需求_文体（艺术）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ext5'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'ext6')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'需求_文体（艺术）无需求'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ext6'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'需求_文体（艺术）无需求'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ext6'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'ext7')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'就读学校(特殊教育机构)(艺术生、体育生)  cdpf_g14c_type'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ext7'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'就读学校(特殊教育机构)(艺术生、体育生)  cdpf_g14c_type'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ext7'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'ext9')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'就读学校   普通教育机构（送教上门）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ext9'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'就读学校   普通教育机构（送教上门）'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'ext9'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'niandu')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'年度'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'niandu'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'年度'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'niandu'
GO
IF ((SELECT COUNT(*) from fn_listextendedproperty('MS_Description', 
'SCHEMA', N'dbo', 
'TABLE', N'dy_eformity_register', 
'COLUMN', N'edu_state')) > 0) 
EXEC sp_updateextendedproperty @name = N'MS_Description', @value = N'教育资助落实状态'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'edu_state'
ELSE
EXEC sp_addextendedproperty @name = N'MS_Description', @value = N'教育资助落实状态'
, @level0type = 'SCHEMA', @level0name = N'dbo'
, @level1type = 'TABLE', @level1name = N'dy_eformity_register'
, @level2type = 'COLUMN', @level2name = N'edu_state'
GO
