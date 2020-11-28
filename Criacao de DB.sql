CREATE TABLE [usuarios] (
  [id] int IDENTITY(1,1) PRIMARY KEY,
  [usuario] nvarchar(255),
  [email] nvarchar(255),
  [senha] nvarchar(255),
  [data_criacao] datetime,
  [data_atualizacao] datetime
)
GO

CREATE TABLE [clientes] (
  [id] int IDENTITY(1,1) PRIMARY KEY,
  [nome] nvarchar(255),
  [sobrenome] nvarchar(255),
  [email] nvarchar(255),
  [senha] nvarchar(255),
  [cpf] nvarchar(255),
  [rg] nvarchar(255),
  [celular] nvarchar(255),
  [cidade] nvarchar(255),
  [estado] nvarchar(255),
  [ativo] nvarchar(255),
  [saldo] nvarchar(255),
  [data_nascimento] date,
  [data_criacao] datetime,
  [data_atualizacao] datetime
)
GO

CREATE TABLE [ativos] (
  [id] int IDENTITY(1,1) PRIMARY KEY,
  [name] nvarchar(255),
  [simbolo] nvarchar(255),
  [valor_atual] int,
  [dias_cotizacao] int,
  [data_criacao] datetime,
  [data_atualizacao] datetime
)
GO

CREATE TABLE [investimentos] (
  [id] int IDENTITY(1,1) PRIMARY KEY,
  [cliente_id] int,
  [ativo_id] int,
  [quantidade] int,
  [valor_corrente] int,
  [resgatado] int,
  [data_criacao] datetime,
	[data_atualizacao] datetime
)
GO

CREATE TABLE [entradas] (
  [id] int IDENTITY(1,1) PRIMARY KEY,
  [cliente_id] int,
  [valor] int,
  [data_criacao] datetime,
  [data_atualizacao] datetime
)
GO

CREATE TABLE [resgates] (
  [id] int IDENTITY(1,1) PRIMARY KEY,
  [cliente_id] int,
  [valor] int,
  [data_criacao] datetime,
  [data_atualizacao] datetime
)
GO

ALTER TABLE [investimentos] ADD FOREIGN KEY ([ativo_id]) REFERENCES [ativos] ([id])
GO

ALTER TABLE [investimentos] ADD FOREIGN KEY ([cliente_id]) REFERENCES [clientes] ([id])
GO

ALTER TABLE [entradas] ADD FOREIGN KEY ([cliente_id]) REFERENCES [clientes] ([id])
GO

ALTER TABLE [resgates] ADD FOREIGN KEY ([cliente_id]) REFERENCES [clientes] ([id])
GO
