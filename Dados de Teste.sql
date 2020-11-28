
-- Criar usuario admin
INSERT INTO usuarios(usuario,email,senha, data_criacao, data_atualizacao) 
VALUES('admin', 'admin@admin.com', 123, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)

GO
-- Criar clientes teste
INSERT INTO clientes( nome, sobrenome, email, senha, cpf, rg, celular, cidade, estado, ativo, saldo, data_nascimento, data_criacao, data_atualizacao)
VALUES ('Joao', 'Queiroz', 'joaozinho@dummy.com', 123, '93656434069', '131234559', '12/03/1999', "1100000000", "Osasco", "São Paulo", 1, 3000, current_timestamp, current_timestamp),
('Dummy', 'Doe', 'dummydoe@dummy.com', 123, '19309054085', '416971994', '02/03/1999', "1100000000", "Itapevi", "São Paulo", 1, 3000, current_timestamp, current_timestamp),
('John', 'Doe', 'jonhdoe@dummy.com', 123, '00479220018', '241299342', '15/08/1999', "1100000000", "Jandira", "São Paulo", 1, 3000, current_timestamp, current_timestamp)

GO
-- Criar ativos teste
INSERT INTO ativos( "name", simbolo, valor_atual, dias_cotizacao, data_criacao, data_atualizacao)
VALUES ('Bitcoin', 'BTC', 20, 1, current_timestamp, current_timestamp),
('Litcoin', 'LTC', 10, 2, current_timestamp, current_timestamp)

GO
--  Criar investimentos de teste
INSERT INTO investimentos( cliente_id, ativo_id, quantidade, valor_corrente, resgatado, data_criacao,data_atualizacao)
VALUES(1, 1, 30, 10, 0, DATEADD(DAY, -20, GETDATE()), DATEADD(DAY, -20, GETDATE())),
(1, 1, 30, 12, 0, DATEADD(DAY, -10, GETDATE()), DATEADD(DAY, -10, GETDATE())),
(1, 2, 50, 7, 0, DATEADD(DAY, -10, GETDATE()), DATEADD(DAY, -10, GETDATE())),
(2, 1, 15, 12, 0, DATEADD(DAY, -10, GETDATE()), DATEADD(DAY, -10, GETDATE())),
(2, 2, 100, 7, 0, DATEADD(DAY, -10, GETDATE()), DATEADD(DAY, -10, GETDATE())),
(2, 2, 70, 7, 1, DATEADD(DAY, -50, GETDATE()), DATEADD(DAY, -50, GETDATE()))

GO
-- Criar entradas financeiras de teste
INSERT INTO entradas( cliente_id, valor, data_criacao, data_atualizacao)
VALUES(1, 50000, DATEADD(DAY, -50, GETDATE()), DATEADD(DAY, -50, GETDATE())),
(2, 50000, DATEADD(DAY, -50, GETDATE()), DATEADD(DAY, -50, GETDATE()))

GO
-- Criar resgates financeiros de teste
INSERT INTO resgates( cliente_id, valor, data_criacao, data_atualizacao)
VALUES (1, 1000, DATEADD(DAY, -10, GETDATE()),DATEADD(DAY, -10, GETDATE())),
(2, 4000, DATEADD(DAY, -10, GETDATE()),DATEADD(DAY, -10, GETDATE()))

GO