-- insert usuarios
INSERT INTO TBUS001_CAD_UNI_USU (COD_IDE_USU, CPF_CNPJ, DAT_BAT, DAT_NSC, DAT_ULT_ATU, EST_CIV, SEX_USU, TIP_PES, IND_MEM, NOM_USU, SEN_ACE_USU)
VALUES ('c26ffb13610b4dd782f774504455dac1', 99999999999, '2015-08-09', '1999-08-12', CURRENT_TIMESTAMP, 'S', 'M', 'F', TRUE, 'AUGUSTO LUIZ SILVA', 'AUGUSTO123');

INSERT INTO TBUS001_CAD_UNI_USU (COD_IDE_USU, CPF_CNPJ, DAT_BAT, DAT_NSC, DAT_ULT_ATU, EST_CIV, SEX_USU, TIP_PES, IND_MEM, NOM_USU, SEN_ACE_USU)
VALUES ('9a9abab097c14358a5a866350c9f9c2e', 88888888888, NULL, '1999-05-10', CURRENT_TIMESTAMP, 'C', 'M', 'F', FALSE, 'JOSÉ DA SILVA', 'JOSE123');

INSERT INTO TBUS001_CAD_UNI_USU (COD_IDE_USU, CPF_CNPJ, DAT_BAT, DAT_NSC, DAT_ULT_ATU, EST_CIV, SEX_USU, TIP_PES, IND_MEM, NOM_USU, SEN_ACE_USU)
VALUES ('993689d027af493ab30b037b338d7f08', 77777777777777, NULL, NULL, CURRENT_TIMESTAMP, NULL, NULL, 'J', FALSE, 'EMPRESA 1 S.A', 'EMP1123');

-- insert enderecos
INSERT INTO TBUS004_CAD_END_USU (COD_CAD_END, BAI_END, CEP_END, COM_END, DAT_ULT_ATU, LOG_END, MUN_END, TIP_END, UF_END)
VALUES (1, 'VILA MARIANA', 99999999, 'PRÓXIMO AO PARQUE', CURRENT_TIMESTAMP, 'RUA 123', 'SÃO PAULO', 'A', 'SP');

INSERT INTO TBUS004_CAD_END_USU(COD_CAD_END, BAI_END, CEP_END, COM_END, DAT_ULT_ATU, LOG_END, MUN_END, TIP_END, UF_END)
VALUES (2, 'TATUAPÉ', 88888888, 'PRÓXIMO AO SHOPPING', CURRENT_TIMESTAMP, 'AVENIDA DO SHOPPING', 'SÃO PAULO', 'C', 'SP');

-- insert enderecosUsuarios

INSERT INTO TBUS005_END_USU (END_PRI, NIV_PRIO, COD_IDE_USU, COD_CAD_END)
VALUES (TRUE, 1, 'c26ffb13610b4dd782f774504455dac1', 1);

INSERT INTO TBUS005_END_USU (END_PRI, NIV_PRIO, COD_IDE_USU, COD_CAD_END)
VALUES (FALSE, 2, 'c26ffb13610b4dd782f774504455dac1', 2);

-- insert telefones

INSERT INTO TBUS003_CAD_TEL_USU (COD_CAD_TEL, DAT_ULT_ATU, TEL_DDD, TEL_NUM, TIP_TEL)
VALUES (1, CURRENT_TIMESTAMP, 11, 99999999, 'C');

INSERT INTO TBUS003_CAD_TEL_USU (COD_CAD_TEL, DAT_ULT_ATU, TEL_DDD, TEL_NUM, TIP_TEL)
VALUES (2, CURRENT_TIMESTAMP, 11, 88888888, 'F');

-- insert telefonesUsuarios

INSERT INTO TBUS006_TEL_USU (COD_IDE_USU, COD_CAD_TEL, NIV_PRIO, TEL_PRI)
VALUES ('c26ffb13610b4dd782f774504455dac1', 1, 1, TRUE);

INSERT INTO TBUS006_TEL_USU (COD_IDE_USU, COD_CAD_TEL, NIV_PRIO, TEL_PRI)
VALUES ('c26ffb13610b4dd782f774504455dac1', 2, 2, FALSE);

INSERT INTO TBUS006_TEL_USU (COD_IDE_USU, COD_CAD_TEL, NIV_PRIO, TEL_PRI)
VALUES ('9a9abab097c14358a5a866350c9f9c2e', 1, 1, TRUE);

-- insert emails

INSERT INTO TBUS002_CAD_CTO_MAIL_USU(MAIL_USU, COD_IDE_USU, DAT_ULT_ATU, MAIL_LOG, NIV_PRI)
VALUES ('AUGUSTO@GMAIL.COM', 'c26ffb13610b4dd782f774504455dac1', CURRENT_TIMESTAMP, TRUE, 1);

INSERT INTO TBUS002_CAD_CTO_MAIL_USU(MAIL_USU, COD_IDE_USU, DAT_ULT_ATU, MAIL_LOG, NIV_PRI)
VALUES ('AUGUSTO@YAHOO.COM', 'c26ffb13610b4dd782f774504455dac1', CURRENT_TIMESTAMP, FALSE, 2);

INSERT INTO TBUS002_CAD_CTO_MAIL_USU(MAIL_USU, COD_IDE_USU, DAT_ULT_ATU, MAIL_LOG, NIV_PRI)
VALUES ('AUGUSTO123@GMAIL.COM', 'c26ffb13610b4dd782f774504455dac1', CURRENT_TIMESTAMP, FALSE, 3);

--INSERT INTO TBUS001_CAD_UNI_USU (CPF_CNPJ, DAT_BAT, DAT_NSC, DAT_ULT_ATU, EST_CIV, SEX_USU, TIP_PES, IND_MEM, NOM_USU, SEN_ACE_USU)
--VALUES (99999999999, '2015-08-09', '1999-08-12', CURRENT_TIMESTAMP, 'S', 'M', 'F', TRUE, 'AUGUSTO LUIZ SILVA', 'AUGUSTO123');