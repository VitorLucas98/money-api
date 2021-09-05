INSERT INTO TB_CATEGORIA (id, nome) VALUES (NULL, 'Eletronicos');
INSERT INTO TB_CATEGORIA (id, nome) VALUES (NULL, 'Limpeza');
INSERT INTO TB_CATEGORIA (id, nome) VALUES (NULL, 'Armamento');
INSERT INTO TB_CATEGORIA (id, nome) VALUES (NULL, 'Alimenticio');

INSERT INTO TB_PESSOA (nome, ativo, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES('Vitor Lucas', true, 'Riacho Fundo 1', '71805406', 'Brasilia', 'casa 20', 'Distrio Federal', 'Qn 05 conjunto 06', '20');
INSERT INTO TB_PESSOA (nome, ativo, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES('Esteves Araujo', true, 'Taguatinga ', '72010010', 'Brasilia', 'apt 201', 'Distrio Federal', 'Quadra C 1 Lotes 9/10 Lojas 1/2	', '201');
INSERT INTO TB_PESSOA (nome, ativo, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES('Talisa Guedes', true, 'Guara', '71009010', 'Brasilia', 'lote 230', 'Distrio Federal', 'SQB 1 Bloco A', '230');
INSERT INTO TB_PESSOA (nome, ativo, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES('Wanderleia Silva', false, 'Asa Sul', '71805406', 'Brasilia', 'atp 601', 'Distrio Federal', 'Quadra SHIGS 703 Bloco P,', '601');
INSERT INTO TB_PESSOA (nome, ativo, bairro, cep, cidade, complemento, estado, logradouro, numero) VALUES('Wangner Bagaceira', true, 'Riacho Fundo 2', '71880044', 'Brasilia', 'Lote 10 ', 'Distrio Federal', 'QN 7D Conjunto 04', '10');

INSERT INTO TB_LANCAMENTO (ID, DATA_PAGAMENTO, DATA_VENCIMENTO, OBSERVACAO, TIPO, VALOR, ID_CATEGORIA, ID_PESSOA) VALUES(NULL, '2020-07-12', '2020-07-15', 'Fatura do videogame', 1, 300, 1, 1);
INSERT INTO TB_LANCAMENTO (ID, DATA_PAGAMENTO, DATA_VENCIMENTO, OBSERVACAO, TIPO, VALOR, ID_CATEGORIA, ID_PESSOA) VALUES(NULL, '2021-01-15', '2022-01-15', 'Compra do Fuzil', 0, 57000, 3, 2);