INSERT INTO ESIdeal.Estacao (abertura, fecho) VALUES ('08:00', '20:00');

INSERT INTO ESIdeal.Administrador (password) VALUES ('admin');

INSERT INTO ESIdeal.Cliente (nif, nome, morada, telefone, email, notSMS, notEmail) VALUES
('123456789', 'Diogo', 'Rua Nozes', '345678923', 'diogo@email.com', 1, 1),
('987654321', 'Marta', 'Rua da toa', '765568535', 'martuxaxuxa@email.com', 0, 1),
('676726282', 'Gonçalo', 'Avenida da avenida', '967543245', 'goncalini@email.com', 1, 1),
('123867556', 'Zé', 'De baixo da ponte', '654378645', 'zezezoca@email.com', 1, 1),
('097563825', 'Flavio', 'Rua Rua', '123481234', 'fuzzymind@email.com', 1, 0);

INSERT INTO ESIdeal.Veiculo (matricula, nifCliente, tipo) VALUES
('DEF456', '123456789', 'eletrico'),
('GHI789', '987654321', 'gasolina'),
('ABC123', '676726282', 'hibridoglo'),
('JKL012', '123867556', 'gasoleo');

INSERT INTO ESIdeal.Funcionario (nrCartao) VALUES
(NULL),
(NULL),
(NULL),
(NULL),
(NULL);

INSERT INTO ESIdeal.Competencia (tipo, nrCartao) VALUES
('universal', 1),
('universal', 3),
('combustao', 4),
('eletrico', 5),
('combustao', 2),
('eletrico', 2),
('gasoleo', 2),
('gasolina', 2);

INSERT INTO ESIdeal.PostoTrabalho (tipo) VALUES
('combustao'),
('universal'),
('gasolina'),
('eletrico'),
('gasoleo');

INSERT INTO ESIdeal.Servico (designacao, tempoNecessario, tipo) VALUES
('Alinhamento da direção', 30, 'universal'),
('Calibragem das rodas', 23, 'universal'),
('Substituição dos pneus', 60, 'universal'),
('Substituição dos injetores', 40, 'universal'),
('Substituição dos calços dos travões', 120, 'universal'),
('Mudança de óleo dos travões', 30, 'universal'),
('Limpeza exterior/interior', 120, 'universal'),
('Substituição do filtro de ar', 30, 'universal'),
('Avaliação do desempenho da bateria', 45, 'eletrico'),
('Substituição da bateria', 25, 'eletrico'),
('Substituição dos filtros de óleo', 90, 'combustao'),
('Substituição do combustivel', 20, 'combustao'),
('Substituição do ar do motor', 40, 'combustao'),
('Substituição do conversor catálico', 60, 'combustao'),
('Substituição da bateria de arranque', 60, 'combustao'),
('Mudança de óelo do motor', 60, 'combustao'),
('Substituição das velas de incandescência', 45, 'gasoleo'),
('Regeneração/Substituição dao filtro de ar de partículas', 125, 'gasoleo'),
('Substituição da válvula do acelerador', 120, 'gasolina'),
('Substituição das velas de ignição', 120, 'gasolina');

-- INSERT INTO ESIdeal.ServicoAgendado (idServico, matricula, nrCartaoFuncionario, tipo) VALUES
-- (9, 'ABC123', 5, 'pendente'),
-- (3, 'DEF456', 3, 'pendente'),
-- (11, 'GHI789', 4, 'pendente'),
-- (1, 'JKL012', 1, 'completo'),
-- (9, 'ABC123', 5, 'incompleto'),
-- (3, 'DEF456', 3, 'incompleto'),
-- (11, 'GHI789', 4, 'incompleto'),
-- (1, 'JKL012', 1, 'incompleto'),
-- (9, 'ABC123', 5, 'incompleto'),
-- (3, 'DEF456', 3, 'pendente'),
-- (11, 'GHI789', 4, 'pendente'),
-- (1, 'JKL012', 1, 'pendente');

-- INSERT INTO ESIdeal.RegistoTurno (nrCartaoFuncionario, inicio, fim) VALUES
-- (1, '2024-01-03 08:00:00', '2024-01-07 17:00:00'),
-- (2, '2023-01-03 09:00:00', '2024-01-07 18:00:00'),
-- (3, '2024-01-03 10:00:00', '2024-01-07 19:00:00'),
-- (4, '2024-01-03 11:00:00', '2024-01-07 20:00:00'),
-- (5, '2024-01-03 12:00:00', '2024-01-07 21:00:00');

-- INSERT INTO ESIdeal.RegistoServico (nrTurno, nrMarcacao, inicio, fim) VALUES
-- (1, 1, '2024-01-07 09:30:00', '2024-01-07 10:00:00'),
-- (2, 2, '2024-01-07 14:15:00', '2024-01-07 15:00:00'),
-- (3, 3, '2024-01-07 11:45:00', '2024-01-07 12:45:00'),
-- (4, 4, '2024-01-07 17:30:00', '2024-01-07 18:15:00'),
-- (5, 5, '2024-01-07 19:00:00', '2024-01-07 19:20:00');

-- INSERT INTO ESIdeal.ServicoAgendadoIncompleto (nrMarcacao, motivo) VALUES
-- (5, 'Peça de reposição não disponível'),
-- (6, 'Cliente não compareceu'),
-- (7, 'Cliente cancelou'),
-- (8, 'Sistema indisponivel'),
-- (9, 'Produto fora de stock');