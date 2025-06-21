-- 1. Modalidade (tipos de dança)
INSERT INTO modalidade (nome) VALUES
('Ballet'),
('Dança de Salão'),
('Dança Contemporânea'),
('Street Dance'),
('Dança do Ventre'),
('Jazz'),
('Sapateado'),
('Flamenco'),
('Forró'),
('Samba de Gafieira'),
('Zouk'),
('Bolero'),
('Tango'),
('Salsa'),
('Merengue'),
('Kizomba'),
('Lambada'),
('Rockabilly'),
('Swing'),
('Lindy Hop'),
('Popping'),
('Locking'),
('Waacking'),
('Vogue'),
('House Dance'),
('Dancehall'),
('Afrobeat'),
('Jazz Funk'),
('Heels'),
('Stiletto'),
('Pole Dance'),
('Dança Afro'),
('Dança Cigana'),
('Dança Indiana'),
('Dança Irlandesa'),
('Dança Havaiana'),
('Dança Flamenca'),
('Dança Gaúcha'),
('Dança Grega'),
('Dança Italiana'),
('Dança Russa'),
('Dança Ucraniana'),
('Dança Polonesa'),
('Dança Alemã'),
('Dança Francesa'),
('Dança Árabe'),
('Dança Chinesa');

-- 2. Equipamentos típicos de escola de dança
INSERT INTO equipamentos (tipo) VALUES
('Barra de ballet'),
('Espelho de parede'),
('Caixa de som profissional'),
('Piso flutuante para dança'),
('Tapete de sapateado'),
('Luz cênica para palco'),
('Ventilador de parede'),
('Cortina blackout'),
('Bastão de alongamento'),
('Colchonete de alongamento'),
('Bola suíça'),
('Step de dança'),
('Faixa elástica'),
('Corda de pular'),
('Kit de cones para marcação'),
('Bastão de jazz'),
('Banco para alongamento'),
('Kit de pesos leves'),
('Fita de ginástica rítmica'),
('Arara para figurinos'),
('Suporte para figurinos'),
('Kit de bambolês'),
('Kit de lenços para dança do ventre'),
('Leques de dança'),
('Sombrinhas de frevo'),
('Chapéus para dança de salão'),
('Luvas para jazz'),
('Saias de dança flamenca'),
('Sapatos de sapateado'),
('Sapatilhas de ballet'),
('Tacos de dança irlandesa'),
('Cintos de moedas para dança do ventre'),
('Lenços de quadril'),
('Pandeiros para dança cigana'),
('Castanholas'),
('Bastão de dança do ventre'),
('Fitas de led para dança contemporânea'),
('Kit de adereços para dança afro'),
('Máscaras para dança teatral'),
('Bastão de fitas'),
('Kit de acessórios para dança havaiana');

-- 3. Sala (salas de dança com capacidade e nome)
INSERT INTO sala (numero, title, capacidade) VALUES
(1, 'Estúdio Principal', 40),
(2, 'Sala de Ballet', 30),
(3, 'Sala de Dança de Salão', 25),
(4, 'Sala Contemporânea', 20),
(5, 'Sala Street Dance', 35),
(6, 'Sala Jazz', 25),
(7, 'Sala Sapateado', 20),
(8, 'Sala Flamenco', 18),
(9, 'Sala Forró', 22),
(10, 'Sala Samba', 24),
(11, 'Sala Zouk', 19),
(12, 'Sala Bolero', 21),
(13, 'Sala Tango', 23),
(14, 'Sala Salsa', 20),
(15, 'Sala Merengue', 18),
(16, 'Sala Kizomba', 22),
(17, 'Sala Lambada', 24),
(18, 'Sala Rockabilly', 19),
(19, 'Sala Swing', 21),
(20, 'Sala Lindy Hop', 23),
(21, 'Sala Popping', 20),
(22, 'Sala Locking', 18),
(23, 'Sala Waacking', 22),
(24, 'Sala Vogue', 24),
(25, 'Sala House', 19),
(26, 'Sala Dancehall', 21),
(27, 'Sala Afrobeat', 23),
(28, 'Sala Jazz Funk', 20),
(29, 'Sala Heels', 18),
(30, 'Sala Stiletto', 22),
(31, 'Sala Pole', 24),
(32, 'Sala Afro', 19),
(33, 'Sala Cigana', 21),
(34, 'Sala Indiana', 23),
(35, 'Sala Irlandesa', 20),
(36, 'Sala Havaiana', 18),
(37, 'Sala Gaúcha', 22),
(38, 'Sala Grega', 24),
(39, 'Sala Italiana', 19),
(40, 'Sala Russa', 21),
(41, 'Sala Ucraniana', 23),
(42, 'Sala Polonesa', 20),
(43, 'Sala Alemã', 18),
(44, 'Sala Francesa', 22),
(45, 'Sala Árabe', 24);

INSERT INTO funcionario (cpf, nome, genero, data_admissao, cargo, salario, email, cep, numero, complemento, cpf_adm) VALUES
('11111111111', 'Carlos Silva', 'M', '2015-03-10', 'Instrutor de Ballet', 3500.00, 'carlos@escoladanca.com', '12345000', 100, 'Apto 101', NULL),
('22222222222', 'Ana Souza', 'F', '2017-07-21', 'Instrutora de Dança de Salão', 3400.00, 'ana@escoladanca.com', '12345001', 101, 'Apto 102', NULL),
('33333333333', 'Pedro Lima', 'M', '2018-01-15', 'Instrutor de Dança Contemporânea', 3300.00, 'pedro@escoladanca.com', '12345002', 102, 'Apto 103', NULL),
('44444444444', 'Mariana Costa', 'F', '2016-09-05', 'Instrutora de Street Dance', 3200.00, 'mariana@escoladanca.com', '12345003', 103, 'Apto 104', NULL),
('55555555555', 'Lucas Martins', 'M', '2019-11-30', 'Instrutor de Dança do Ventre', 3100.00, 'lucas@escoladanca.com', '12345004', 104, 'Apto 105', NULL),
('10000000021', 'Gabriela Torres', 'F', '2020-01-01', 'Instrutora de Jazz', 3200.00, 'gabriela.torres@escoladanca.com', '12345021', 121, 'Apto 121', NULL),
('10000000022', 'Rafael Mendes', 'M', '2020-01-02', 'Instrutor de Sapateado', 3200.00, 'rafael.mendes@escoladanca.com', '12345022', 122, 'Apto 122', NULL),
('10000000023', 'Juliana Prado', 'F', '2020-01-03', 'Instrutora de Flamenco', 3200.00, 'juliana.prado@escoladanca.com', '12345023', 123, 'Apto 123', NULL),
('10000000024', 'Lucas Faria', 'M', '2020-01-04', 'Instrutor de Forró', 3200.00, 'lucas.faria@escoladanca.com', '12345024', 124, 'Apto 124', NULL),
('10000000025', 'Patrícia Lima', 'F', '2020-01-05', 'Instrutora de Samba', 3200.00, 'patricia.lima@escoladanca.com', '12345025', 125, 'Apto 125', NULL),
('10000000026', 'Vinícius Souza', 'M', '2020-01-06', 'Instrutor de Zouk', 3200.00, 'vinicius.souza@escoladanca.com', '12345026', 126, 'Apto 126', NULL),
('10000000027', 'Amanda Rocha', 'F', '2020-01-07', 'Instrutora de Bolero', 3200.00, 'amanda.rocha@escoladanca.com', '12345027', 127, 'Apto 127', NULL),
('10000000028', 'Felipe Duarte', 'M', '2020-01-08', 'Instrutor de Tango', 3200.00, 'felipe.duarte@escoladanca.com', '12345028', 128, 'Apto 128', NULL),
('10000000029', 'Bianca Alves', 'F', '2020-01-09', 'Instrutora de Salsa', 3200.00, 'bianca.alves@escoladanca.com', '12345029', 129, 'Apto 129', NULL),
('10000000030', 'Rodrigo Reis', 'M', '2020-01-10', 'Instrutor de Merengue', 3200.00, 'rodrigo.reis@escoladanca.com', '12345030', 130, 'Apto 130', NULL),
('10000000031', 'Carolina Dias', 'F', '2020-01-11', 'Instrutora de Kizomba', 3200.00, 'carolina.dias@escoladanca.com', '12345031', 131, 'Apto 131', NULL),
('10000000032', 'Eduardo Ramos', 'M', '2020-01-12', 'Instrutor de Lambada', 3200.00, 'eduardo.ramos@escoladanca.com', '12345032', 132, 'Apto 132', NULL),
('10000000033', 'Renata Martins', 'F', '2020-01-13', 'Instrutora de Rockabilly', 3200.00, 'renata.martins@escoladanca.com', '12345033', 133, 'Apto 133', NULL),
('10000000034', 'Gustavo Lopes', 'M', '2020-01-14', 'Instrutor de Swing', 3200.00, 'gustavo.lopes@escoladanca.com', '12345034', 134, 'Apto 134', NULL),
('10000000035', 'Marina Barros', 'F', '2020-01-15', 'Instrutora de Lindy Hop', 3200.00, 'marina.barros@escoladanca.com', '12345035', 135, 'Apto 135', NULL),
('10000000036', 'Thiago Nunes', 'M', '2020-01-16', 'Instrutor de Popping', 3200.00, 'thiago.nunes@escoladanca.com', '12345036', 136, 'Apto 136', NULL),
('10000000037', 'Aline Castro', 'F', '2020-01-17', 'Instrutora de Locking', 3200.00, 'aline.castro@escoladanca.com', '12345037', 137, 'Apto 137', NULL),
('10000000038', 'Bruno Teixeira', 'M', '2020-01-18', 'Instrutor de Waacking', 3200.00, 'bruno.teixeira@escoladanca.com', '12345038', 138, 'Apto 138', NULL),
('10000000039', 'Letícia Pires', 'F', '2020-01-19', 'Instrutora de Vogue', 3200.00, 'leticia.pires@escoladanca.com', '12345039', 139, 'Apto 139', NULL),
('10000000040', 'Daniel Cardoso', 'M', '2020-01-20', 'Instrutor de House', 3200.00, 'daniel.cardoso@escoladanca.com', '12345040', 140, 'Apto 140', NULL),
('10000000041', 'Paula Ferreira', 'F', '2020-01-21', 'Instrutora de Dancehall', 3200.00, 'paula.ferreira@escoladanca.com', '12345041', 141, 'Apto 141', NULL),
('10000000042', 'Henrique Silva', 'M', '2020-01-22', 'Instrutor de Afrobeat', 3200.00, 'henrique.silva@escoladanca.com', '12345042', 142, 'Apto 142', NULL),
('10000000043', 'Tatiane Gomes', 'F', '2020-01-23', 'Instrutora de Jazz Funk', 3200.00, 'tatiane.gomes@escoladanca.com', '12345043', 143, 'Apto 143', NULL),
('10000000044', 'Alexandre Pinto', 'M', '2020-01-24', 'Instrutor de Heels', 3200.00, 'alexandre.pinto@escoladanca.com', '12345044', 144, 'Apto 144', NULL),
('10000000045', 'Camila Rocha', 'F', '2020-01-25', 'Instrutora de Stiletto', 3200.00, 'camila.rocha@escoladanca.com', '12345045', 145, 'Apto 145', NULL),
('10000000046', 'Fernando Souza', 'M', '2020-01-26', 'Instrutor de Pole Dance', 3200.00, 'fernando.souza@escoladanca.com', '12345046', 146, 'Apto 146', NULL),
('10000000047', 'Isabela Lima', 'F', '2020-01-27', 'Instrutora de Dança Afro', 3200.00, 'isabela.lima@escoladanca.com', '12345047', 147, 'Apto 147', NULL),
('10000000048', 'Marcelo Vieira', 'M', '2020-01-28', 'Instrutor de Dança Cigana', 3200.00, 'marcelo.vieira@escoladanca.com', '12345048', 148, 'Apto 148', NULL),
('10000000049', 'Natália Souza', 'F', '2020-01-29', 'Instrutora de Dança Indiana', 3200.00, 'natalia.souza@escoladanca.com', '12345049', 149, 'Apto 149', NULL),
('10000000050', 'Otávio Ramos', 'M', '2020-01-30', 'Instrutor de Dança Irlandesa', 3200.00, 'otavio.ramos@escoladanca.com', '12345050', 150, 'Apto 150', NULL),
('10000000051', 'Priscila Duarte', 'F', '2020-01-31', 'Instrutora de Dança Havaiana', 3200.00, 'priscila.duarte@escoladanca.com', '12345051', 151, 'Apto 151', NULL),
('10000000052', 'Ricardo Lopes', 'M', '2020-02-01', 'Instrutor de Dança Gaúcha', 3200.00, 'ricardo.lopes@escoladanca.com', '12345052', 152, 'Apto 152', NULL),
('10000000053', 'Sabrina Costa', 'F', '2020-02-02', 'Instrutora de Dança Grega', 3200.00, 'sabrina.costa@escoladanca.com', '12345053', 153, 'Apto 153', NULL),
('10000000054', 'Tiago Martins', 'M', '2020-02-03', 'Instrutor de Dança Italiana', 3200.00, 'tiago.martins@escoladanca.com', '12345054', 154, 'Apto 154', NULL),
('10000000055', 'Ursula Barros', 'F', '2020-02-04', 'Instrutora de Dança Russa', 3200.00, 'ursula.barros@escoladanca.com', '12345055', 155, 'Apto 155', NULL),
('10000000056', 'Vitor Nunes', 'M', '2020-02-05', 'Instrutor de Dança Ucraniana', 3200.00, 'vitor.nunes@escoladanca.com', '12345056', 156, 'Apto 156', NULL),
('10000000057', 'Wanda Teixeira', 'F', '2020-02-06', 'Instrutora de Dança Polonesa', 3200.00, 'wanda.teixeira@escoladanca.com', '12345057', 157, 'Apto 157', NULL),
('10000000058', 'Xavier Cardoso', 'M', '2020-02-07', 'Instrutor de Dança Alemã', 3200.00, 'xavier.cardoso@escoladanca.com', '12345058', 158, 'Apto 158', NULL),
('10000000059', 'Yasmin Ferreira', 'F', '2020-02-08', 'Instrutora de Dança Francesa', 3200.00, 'yasmin.ferreira@escoladanca.com', '12345059', 159, 'Apto 159', NULL),
('10000000060', 'Zeca Silva', 'M', '2020-02-09', 'Instrutor de Dança Árabe', 3200.00, 'zeca.silva@escoladanca.com', '12345060', 160, 'Apto 160', NULL),
('90000000001', 'Patrícia Souza', 'F', '2014-02-10', 'Administrador', 5000.00, 'patricia.souza@escoladanca.com', '12345900', 201, 'Apto 201', NULL),
('90000000002', 'Roberto Lima', 'M', '2013-08-15', 'Administrador', 5200.00, 'roberto.lima@escoladanca.com', '12345901', 202, 'Apto 202', NULL),
('90000000003', 'Fernanda Alves', 'F', '2016-05-20', 'Administrador', 5100.00, 'fernanda.alves@escoladanca.com', '12345902', 203, 'Apto 203', NULL),
('90000000004', 'Marcelo Dias', 'M', '2012-11-30', 'Administrador', 5300.00, 'marcelo.dias@escoladanca.com', '12345903', 204, 'Apto 204', NULL),
('90000000005', 'Juliana Martins', 'F', '2015-04-18', 'Administrador', 5050.00, 'juliana.martins@escoladanca.com', '12345904', 205, 'Apto 205', NULL);
-- 5. Instrutor (FK para funcionario)
INSERT INTO instrutor (cpf) VALUES
('11111111111'),
('22222222222'),
('33333333333'),
('44444444444'),
('55555555555'),
('10000000021'),
('10000000022'),
('10000000023'),
('10000000024'),
('10000000025'),
('10000000026'),
('10000000027'),
('10000000028'),
('10000000029'),
('10000000030'),
('10000000031'),
('10000000032'),
('10000000033'),
('10000000034'),
('10000000035'),
('10000000036'),
('10000000037'),
('10000000038'),
('10000000039'),
('10000000040'),
('10000000041'),
('10000000042'),
('10000000043'),
('10000000044'),
('10000000045'),
('10000000046'),
('10000000047'),
('10000000048'),
('10000000049'),
('10000000050'),
('10000000051'),
('10000000052'),
('10000000053'),
('10000000054'),
('10000000055'),
('10000000056'),
('10000000057'),
('10000000058'),
('10000000059'),
('10000000060');

INSERT INTO administrativo (cpf, nivel_acessos) VALUES
('90000000001', 3),
('90000000002', 3),
('90000000003', 2),
('90000000004', 2),
('90000000005', 1);

-- Atualize o campo cpf_adm para cada funcionário conforme desejado
UPDATE funcionario SET cpf_adm = '90000000001' WHERE cpf IN ('11111111111','22222222222','10000000026','10000000027','10000000036','10000000037','10000000046','10000000047','10000000056','10000000057');
UPDATE funcionario SET cpf_adm = '90000000002' WHERE cpf IN ('33333333333','44444444444','10000000028','10000000029','10000000038','10000000039','10000000048','10000000049','10000000058','10000000059');
UPDATE funcionario SET cpf_adm = '90000000003' WHERE cpf IN ('55555555555','10000000021','10000000030','10000000031','10000000040','10000000041','10000000050','10000000051','10000000060');
UPDATE funcionario SET cpf_adm = '90000000004' WHERE cpf IN ('10000000022','10000000023','10000000032','10000000033','10000000042','10000000043','10000000052','10000000053');
UPDATE funcionario SET cpf_adm = '90000000005' WHERE cpf IN ('10000000024','10000000025','10000000034','10000000035','10000000044','10000000045','10000000054','10000000055');

-- 6. Alunos (exemplo com 10 alunos)
INSERT INTO aluno (cpf, nome, genero, data_nasc, email) VALUES
('10000000001', 'João Pereira', 'M', '2000-01-15', 'joao.pereira@email.com'),
('10000000002', 'Maria Oliveira', 'F', '1999-05-23', 'maria.oliveira@email.com'),
('10000000003', 'Pedro Santos', 'M', '2001-08-12', 'pedro.santos@email.com'),
('10000000004', 'Ana Costa', 'F', '2002-02-20', 'ana.costa@email.com'),
('10000000005', 'Lucas Almeida', 'M', '1998-11-30', 'lucas.almeida@email.com'),
('10000000006', 'Carla Souza', 'F', '2000-06-18', 'carla.souza@email.com'),
('10000000007', 'Rafael Lima', 'M', '1997-09-25', 'rafael.lima@email.com'),
('10000000008', 'Juliana Rocha', 'F', '2001-04-10', 'juliana.rocha@email.com'),
('10000000009', 'Bruno Martins', 'M', '1999-12-05', 'bruno.martins@email.com'),
('10000000010', 'Fernanda Dias', 'F', '2000-07-22', 'fernanda.dias@email.com'),
('20000000001', 'Alice Souza', 'F', '2001-01-01', 'alice.souza@email.com'),
('20000000002', 'Bruno Lima', 'M', '2001-01-02', 'bruno.lima@email.com'),
('20000000003', 'Carla Mendes', 'F', '2001-01-03', 'carla.mendes@email.com'),
('20000000004', 'Diego Torres', 'M', '2001-01-04', 'diego.torres@email.com'),
('20000000005', 'Elisa Prado', 'F', '2001-01-05', 'elisa.prado@email.com'),
('20000000006', 'Fábio Faria', 'M', '2001-01-06', 'fabio.faria@email.com'),
('20000000007', 'Giovana Lima', 'F', '2001-01-07', 'giovana.lima@email.com'),
('20000000008', 'Henrique Rocha', 'M', '2001-01-08', 'henrique.rocha@email.com'),
('20000000009', 'Isabela Duarte', 'F', '2001-01-09', 'isabela.duarte@email.com'),
('20000000010', 'João Alves', 'M', '2001-01-10', 'joao.alves@email.com'),
('20000000011', 'Karen Reis', 'F', '2001-01-11', 'karen.reis@email.com'),
('20000000012', 'Leonardo Dias', 'M', '2001-01-12', 'leonardo.dias@email.com'),
('20000000013', 'Marina Ramos', 'F', '2001-01-13', 'marina.ramos@email.com'),
('20000000014', 'Nicolas Martins', 'M', '2001-01-14', 'nicolas.martins@email.com'),
('20000000015', 'Olívia Lopes', 'F', '2001-01-15', 'olivia.lopes@email.com'),
('20000000016', 'Paulo Barros', 'M', '2001-01-16', 'paulo.barros@email.com'),
('20000000017', 'Quésia Nunes', 'F', '2001-01-17', 'quesia.nunes@email.com'),
('20000000018', 'Rafael Castro', 'M', '2001-01-18', 'rafael.castro@email.com'),
('20000000019', 'Sabrina Teixeira', 'F', '2001-01-19', 'sabrina.teixeira@email.com'),
('20000000020', 'Thiago Pires', 'M', '2001-01-20', 'thiago.pires@email.com'),
('20000000021', 'Ursula Cardoso', 'F', '2001-01-21', 'ursula.cardoso@email.com'),
('20000000022', 'Victor Ferreira', 'M', '2001-01-22', 'victor.ferreira@email.com'),
('20000000023', 'Wanda Silva', 'F', '2001-01-23', 'wanda.silva@email.com'),
('20000000024', 'Xavier Gomes', 'M', '2001-01-24', 'xavier.gomes@email.com'),
('20000000025', 'Yasmin Pinto', 'F', '2001-01-25', 'yasmin.pinto@email.com'),
('20000000026', 'Zeca Rocha', 'M', '2001-01-26', 'zeca.rocha@email.com'),
('20000000027', 'Ana Paula', 'F', '2001-01-27', 'ana.paula@email.com'),
('20000000028', 'Brenda Souza', 'F', '2001-01-28', 'brenda.souza@email.com'),
('20000000029', 'Caio Lima', 'M', '2001-01-29', 'caio.lima@email.com'),
('20000000030', 'Diana Mendes', 'F', '2001-01-30', 'diana.mendes@email.com'),
('20000000031', 'Eduardo Torres', 'M', '2001-01-31', 'eduardo.torres@email.com'),
('20000000032', 'Fernanda Prado', 'F', '2001-02-01', 'fernanda.prado@email.com'),
('20000000033', 'Guilherme Faria', 'M', '2001-02-02', 'guilherme.faria@email.com'),
('20000000034', 'Helena Lima', 'F', '2001-02-03', 'helena.lima@email.com'),
('20000000035', 'Igor Rocha', 'M', '2001-02-04', 'igor.rocha@email.com'),
('20000000036', 'Juliana Duarte', 'F', '2001-02-05', 'juliana.duarte@email.com'),
('20000000037', 'Kleber Alves', 'M', '2001-02-06', 'kleber.alves@email.com'),
('20000000038', 'Larissa Reis', 'F', '2001-02-07', 'larissa.reis@email.com'),
('20000000039', 'Marcelo Dias', 'M', '2001-02-08', 'marcelo.dias@email.com'),
('20000000040', 'Natália Ramos', 'F', '2001-02-09', 'natalia.ramos@email.com');

-- 7. Transacao_entrada (pagamentos de matrícula)
INSERT INTO transacao_entrada (valor, data_hora, descricao, emissor, id_nota_fiscal) VALUES
(200.00, '2025-01-10 09:00:00', 'Pagamento matrícula', 'Aluno', 'NF001'),
(200.00, '2025-01-11 10:00:00', 'Pagamento matrícula', 'Aluno', 'NF002'),
(200.00, '2025-01-12 11:00:00', 'Pagamento matrícula', 'Aluno', 'NF003'),
(200.00, '2025-01-13 12:00:00', 'Pagamento matrícula', 'Aluno', 'NF004'),
(200.00, '2025-01-14 13:00:00', 'Pagamento matrícula', 'Aluno', 'NF005'),
(200.00, '2025-01-15 14:00:00', 'Pagamento matrícula', 'Aluno', 'NF006'),
(200.00, '2025-01-16 15:00:00', 'Pagamento matrícula', 'Aluno', 'NF007'),
(200.00, '2025-01-17 16:00:00', 'Pagamento matrícula', 'Aluno', 'NF008'),
(200.00, '2025-01-18 17:00:00', 'Pagamento matrícula', 'Aluno', 'NF009'),
(200.00, '2025-01-19 18:00:00', 'Pagamento matrícula', 'Aluno', 'NF010');

INSERT INTO transacao_entrada (valor, data_hora, descricao, emissor, id_nota_fiscal) VALUES
(210.00, '2025-01-20 09:00:00', 'Pagamento matrícula', 'Aluno', 'NF011'),
(210.00, '2025-01-21 10:00:00', 'Pagamento matrícula', 'Aluno', 'NF012'),
(210.00, '2025-01-22 11:00:00', 'Pagamento matrícula', 'Aluno', 'NF013'),
(210.00, '2025-01-23 12:00:00', 'Pagamento matrícula', 'Aluno', 'NF014'),
(210.00, '2025-01-24 13:00:00', 'Pagamento matrícula', 'Aluno', 'NF015'),
(210.00, '2025-01-25 14:00:00', 'Pagamento matrícula', 'Aluno', 'NF016'),
(210.00, '2025-01-26 15:00:00', 'Pagamento matrícula', 'Aluno', 'NF017'),
(210.00, '2025-01-27 16:00:00', 'Pagamento matrícula', 'Aluno', 'NF018'),
(210.00, '2025-01-28 17:00:00', 'Pagamento matrícula', 'Aluno', 'NF019'),
(210.00, '2025-01-29 18:00:00', 'Pagamento matrícula', 'Aluno', 'NF020'),
(210.00, '2025-01-30 09:00:00', 'Pagamento matrícula', 'Aluno', 'NF021'),
(210.00, '2025-01-31 10:00:00', 'Pagamento matrícula', 'Aluno', 'NF022'),
(210.00, '2025-02-01 11:00:00', 'Pagamento matrícula', 'Aluno', 'NF023'),
(210.00, '2025-02-02 12:00:00', 'Pagamento matrícula', 'Aluno', 'NF024'),
(210.00, '2025-02-03 13:00:00', 'Pagamento matrícula', 'Aluno', 'NF025'),
(210.00, '2025-02-04 14:00:00', 'Pagamento matrícula', 'Aluno', 'NF026'),
(210.00, '2025-02-05 15:00:00', 'Pagamento matrícula', 'Aluno', 'NF027'),
(210.00, '2025-02-06 16:00:00', 'Pagamento matrícula', 'Aluno', 'NF028'),
(210.00, '2025-02-07 17:00:00', 'Pagamento matrícula', 'Aluno', 'NF029'),
(210.00, '2025-02-08 18:00:00', 'Pagamento matrícula', 'Aluno', 'NF030'),
(210.00, '2025-02-09 09:00:00', 'Pagamento matrícula', 'Aluno', 'NF031'),
(210.00, '2025-02-10 10:00:00', 'Pagamento matrícula', 'Aluno', 'NF032'),
(210.00, '2025-02-11 11:00:00', 'Pagamento matrícula', 'Aluno', 'NF033'),
(210.00, '2025-02-12 12:00:00', 'Pagamento matrícula', 'Aluno', 'NF034'),
(210.00, '2025-02-13 13:00:00', 'Pagamento matrícula', 'Aluno', 'NF035'),
(210.00, '2025-02-14 14:00:00', 'Pagamento matrícula', 'Aluno', 'NF036'),
(210.00, '2025-02-15 15:00:00', 'Pagamento matrícula', 'Aluno', 'NF037'),
(210.00, '2025-02-16 16:00:00', 'Pagamento matrícula', 'Aluno', 'NF038'),
(210.00, '2025-02-17 17:00:00', 'Pagamento matrícula', 'Aluno', 'NF039'),
(210.00, '2025-02-18 18:00:00', 'Pagamento matrícula', 'Aluno', 'NF040'),
(210.00, '2025-02-19 09:00:00', 'Pagamento matrícula', 'Aluno', 'NF041'),
(210.00, '2025-02-20 10:00:00', 'Pagamento matrícula', 'Aluno', 'NF042'),
(210.00, '2025-02-21 11:00:00', 'Pagamento matrícula', 'Aluno', 'NF043'),
(210.00, '2025-02-22 12:00:00', 'Pagamento matrícula', 'Aluno', 'NF044'),
(210.00, '2025-02-23 13:00:00', 'Pagamento matrícula', 'Aluno', 'NF045'),
(210.00, '2025-02-24 14:00:00', 'Pagamento matrícula', 'Aluno', 'NF046'),
(210.00, '2025-02-25 15:00:00', 'Pagamento matrícula', 'Aluno', 'NF047'),
(210.00, '2025-02-26 16:00:00', 'Pagamento matrícula', 'Aluno', 'NF048'),
(210.00, '2025-02-27 17:00:00', 'Pagamento matrícula', 'Aluno', 'NF049'),
(210.00, '2025-02-28 18:00:00', 'Pagamento matrícula', 'Aluno', 'NF050');
 (45.00, '2025-01-10 09:00:00', 'Inscrição Campeonato 1', 'PIX', 'NF001'),
  (48.00, '2025-01-10 09:30:00', 'Inscrição Campeonato 1', 'PIX', 'NF002'),
  (50.00, '2025-01-11 10:00:00', 'Inscrição Campeonato 1', 'Cartão', 'NF003'),
  (30.00, '2025-01-12 11:00:00', 'Inscrição Campeonato 1', 'Dinheiro', 'NF004'),
  (20.00, '2025-01-13 11:30:00', 'Inscrição Campeonato 1', 'PIX', 'NF005'),
  (25.00, '2025-03-01 09:15:00', 'Inscrição Campeonato 2', 'PIX', 'NF006'),
  (44.00, '2025-03-01 10:00:00', 'Inscrição Campeonato 2', 'Cartão', 'NF007'),
  (35.00, '2025-03-02 11:45:00', 'Inscrição Campeonato 2', 'PIX', 'NF008'),
  (50.00, '2025-03-03 13:00:00', 'Inscrição Campeonato 2', 'PIX', 'NF009'),
  (47.00, '2025-03-04 14:30:00', 'Inscrição Campeonato 2', 'Dinheiro', 'NF010'),
  (32.00, '2025-05-01 08:00:00', 'Inscrição Campeonato 3', 'Cartão', 'NF051'),
  (36.00, '2025-05-01 09:30:00', 'Inscrição Campeonato 3', 'PIX', 'NF052'),
  (50.00, '2025-05-01 10:45:00', 'Inscrição Campeonato 3', 'Cartão', 'NF053'),
  (28.00, '2025-05-02 12:00:00', 'Inscrição Campeonato 3', 'PIX', 'NF054'),
  (45.00, '2025-05-03 14:20:00', 'Inscrição Campeonato 3', 'Dinheiro', 'NF055'),
  (22.00, '2025-07-20 09:00:00', 'Inscrição Campeonato 4', 'PIX', 'NF056'),
  (39.00, '2025-07-21 10:30:00', 'Inscrição Campeonato 4', 'Cartão', 'NF057'),
  (30.00, '2025-07-22 11:50:00', 'Inscrição Campeonato 4', 'PIX', 'NF058'),
  (46.00, '2025-07-23 13:10:00', 'Inscrição Campeonato 4', 'PIX', 'NF059'),
  (50.00, '2025-07-24 15:00:00', 'Inscrição Campeonato 4', 'Dinheiro', 'NF060'),
  (40.00, '2025-10-10 08:10:00', 'Inscrição Campeonato 5', 'PIX', 'NF061'),
  (38.00, '2025-10-11 09:40:00', 'Inscrição Campeonato 5', 'PIX', 'NF062'),
  (29.00, '2025-10-12 11:00:00', 'Inscrição Campeonato 5', 'Cartão', 'NF063'),
  (33.00, '2025-10-13 13:30:00', 'Inscrição Campeonato 5', 'Dinheiro', 'NF064'),
  (49.00, '2025-10-14 16:00:00', 'Inscrição Campeonato 5', 'Cartão', 'NF065'),
  (27.00, '2025-10-15 10:15:00', 'Inscrição Campeonato 5', 'PIX', 'NF066'),
  (23.00, '2025-10-16 12:20:00', 'Inscrição Campeonato 5', 'PIX', 'NF067'),
  (36.00, '2025-10-17 14:10:00', 'Inscrição Campeonato 5', 'PIX', 'NF068'),
  (31.00, '2025-10-18 15:00:00', 'Inscrição Campeonato 5', 'Cartão', 'NF069'),
  (45.00, '2025-10-19 17:45:00', 'Inscrição Campeonato 5', 'PIX', 'NF070');

-- 8. Turma (associando modalidades e instrutores)
INSERT INTO turma (qtd_aulas_semanais, horario_inicio, horario_fim, tamanho, genero, nivel, id_modalidade, cpf_instrutor) VALUES
(3, '08:00', '09:30', 20, 'M', 'Iniciante', 1, '11111111111'), -- Ballet
(2, '10:00', '11:30', 15, 'F', 'Intermediário', 2, '22222222222'), -- Dança de Salão
(4, '14:00', '15:30', 25, 'M', 'Avançado', 3, '33333333333'), -- Contemporânea
(3, '16:00', '17:30', 20, 'F', 'Iniciante', 4, '44444444444'), -- Street Dance
(2, '18:00', '19:30', 30, 'M', 'Intermediário', 5, '55555555555'), -- Dança do Ventre
(2, '08:00', '09:00', 15, 'M', 'Iniciante', 6, '10000000021'),
(3, '09:00', '10:00', 20, 'F', 'Intermediário', 7, '10000000022'),
(2, '10:00', '11:00', 18, 'M', 'Avançado', 8, '10000000023'),
(3, '11:00', '12:00', 22, 'F', 'Iniciante', 9, '10000000024'),
(2, '12:00', '13:00', 16, 'M', 'Intermediário', 10, '10000000025'),
(3, '13:00', '14:00', 19, 'F', 'Avançado', 11, '10000000026'),
(2, '14:00', '15:00', 17, 'M', 'Iniciante', 12, '10000000027'),
(3, '15:00', '16:00', 21, 'F', 'Intermediário', 13, '10000000028'),
(2, '16:00', '17:00', 23, 'M', 'Avançado', 14, '10000000029'),
(3, '17:00', '18:00', 20, 'F', 'Iniciante', 15, '10000000030'),
(2, '18:00', '19:00', 18, 'M', 'Intermediário', 16, '10000000031'),
(3, '19:00', '20:00', 16, 'F', 'Avançado', 17, '10000000032'),
(2, '20:00', '21:00', 15, 'M', 'Iniciante', 18, '10000000033'),
(3, '21:00', '22:00', 19, 'F', 'Intermediário', 19, '10000000034'),
(2, '08:30', '09:30', 17, 'M', 'Avançado', 20, '10000000035'),
(3, '09:30', '10:30', 21, 'F', 'Iniciante', 21, '10000000036'),
(2, '10:30', '11:30', 23, 'M', 'Intermediário', 22, '10000000037'),
(3, '11:30', '12:30', 20, 'F', 'Avançado', 23, '10000000038'),
(2, '12:30', '13:30', 18, 'M', 'Iniciante', 24, '10000000039'),
(3, '13:30', '14:30', 16, 'F', 'Intermediário', 25, '10000000040'),
(2, '14:30', '15:30', 15, 'M', 'Avançado', 26, '10000000041'),
(3, '15:30', '16:30', 19, 'F', 'Iniciante', 27, '10000000042'),
(2, '16:30', '17:30', 21, 'M', 'Intermediário', 28, '10000000043'),
(3, '17:30', '18:30', 23, 'F', 'Avançado', 29, '10000000044'),
(2, '18:30', '19:30', 20, 'M', 'Iniciante', 30, '10000000045'),
(3, '19:30', '20:30', 18, 'F', 'Intermediário', 31, '10000000046'),
(2, '20:30', '21:30', 16, 'M', 'Avançado', 32, '10000000047'),
(3, '21:30', '22:30', 15, 'F', 'Iniciante', 33, '10000000048'),
(2, '08:15', '09:15', 19, 'M', 'Intermediário', 34, '10000000049'),
(3, '09:15', '10:15', 21, 'F', 'Avançado', 35, '10000000050'),
(2, '10:15', '11:15', 23, 'M', 'Iniciante', 36, '10000000051'),
(3, '11:15', '12:15', 20, 'F', 'Intermediário', 37, '10000000052'),
(2, '12:15', '13:15', 18, 'M', 'Avançado', 38, '10000000053'),
(3, '13:15', '14:15', 16, 'F', 'Iniciante', 39, '10000000054'),
(2, '14:15', '15:15', 15, 'M', 'Intermediário', 40, '10000000055'),
(3, '15:15', '16:15', 19, 'F', 'Avançado', 1, '10000000056'),
(2, '16:15', '17:15', 21, 'M', 'Iniciante', 2, '10000000057'),
(3, '17:15', '18:15', 23, 'F', 'Intermediário', 3, '10000000058'),
(2, '18:15', '19:15', 20, 'M', 'Avançado', 4, '10000000059'),
(3, '19:15', '20:15', 18, 'F', 'Iniciante', 5, '10000000060');

-- 9. Matricula (FK para aluno, turma e transacao_entrada)
INSERT INTO matricula (data_matricula, valor, cpf_aluno, id_transacao, id_turma) VALUES
('2025-01-10', 200.00, '10000000001', 1, 1),
('2025-01-11', 200.00, '10000000002', 2, 2),
('2025-01-12', 200.00, '10000000003', 3, 3),
('2025-01-13', 200.00, '10000000004', 4, 4),
('2025-01-14', 200.00, '10000000005', 5, 5),
('2025-01-15', 200.00, '10000000006', 6, 1),
('2025-01-16', 200.00, '10000000007', 7, 2),
('2025-01-17', 200.00, '10000000008', 8, 3),
('2025-01-18', 200.00, '10000000009', 9, 4),
('2025-01-19', 200.00, '10000000010', 10, 5),
('2025-01-20', 210.00, '20000000001', 11, 6),
('2025-01-21', 210.00, '20000000002', 12, 7),
('2025-01-22', 210.00, '20000000003', 13, 8),
('2025-01-23', 210.00, '20000000004', 14, 9),
('2025-01-24', 210.00, '20000000005', 15, 10),
('2025-01-25', 210.00, '20000000006', 16, 11),
('2025-01-26', 210.00, '20000000007', 17, 12),
('2025-01-27', 210.00, '20000000008', 18, 13),
('2025-01-28', 210.00, '20000000009', 19, 14),
('2025-01-29', 210.00, '20000000010', 20, 15),
('2025-01-30', 210.00, '20000000011', 21, 16),
('2025-01-31', 210.00, '20000000012', 22, 17),
('2025-02-01', 210.00, '20000000013', 23, 18),
('2025-02-02', 210.00, '20000000014', 24, 19),
('2025-02-03', 210.00, '20000000015', 25, 20),
('2025-02-04', 210.00, '20000000016', 26, 21),
('2025-02-05', 210.00, '20000000017', 27, 22),
('2025-02-06', 210.00, '20000000018', 28, 23),
('2025-02-07', 210.00, '20000000019', 29, 24),
('2025-02-08', 210.00, '20000000020', 30, 25),
('2025-02-09', 210.00, '20000000021', 31, 26),
('2025-02-10', 210.00, '20000000022', 32, 27),
('2025-02-11', 210.00, '20000000023', 33, 28),
('2025-02-12', 210.00, '20000000024', 34, 29),
('2025-02-13', 210.00, '20000000025', 35, 30),
('2025-02-14', 210.00, '20000000026', 36, 31),
('2025-02-15', 210.00, '20000000027', 37, 32),
('2025-02-16', 210.00, '20000000028', 38, 33),
('2025-02-17', 210.00, '20000000029', 39, 34),
('2025-02-18', 210.00, '20000000030', 40, 35),
('2025-02-19', 210.00, '20000000031', 41, 36),
('2025-02-20', 210.00, '20000000032', 42, 37),
('2025-02-21', 210.00, '20000000033', 43, 38),
('2025-02-22', 210.00, '20000000034', 44, 39),
('2025-02-23', 210.00, '20000000035', 45, 40),
('2025-02-24', 210.00, '20000000036', 46, 1),
('2025-02-25', 210.00, '20000000037', 47, 2),
('2025-02-26', 210.00, '20000000038', 48, 3),
('2025-02-27', 210.00, '20000000039', 49, 4),
('2025-02-28', 210.00, '20000000040', 50, 5);

-- Turma_sala (relacionando turma à sala coerente com a modalidade e categoria da sala)
INSERT INTO turma_sala (id_turma, id_sala, inicio_locacao, fim_locacao) VALUES
(6, 6, '2025-01-01', '2025-12-31'),    -- Jazz
(7, 7, '2025-01-01', '2025-12-31'),    -- Sapateado
(8, 8, '2025-01-01', '2025-12-31'),    -- Flamenco
(9, 9, '2025-01-01', '2025-12-31'),    -- Forró
(10, 10, '2025-01-01', '2025-12-31'),  -- Samba
(11, 11, '2025-01-01', '2025-12-31'),  -- Zouk
(12, 12, '2025-01-01', '2025-12-31'),  -- Bolero
(13, 13, '2025-01-01', '2025-12-31'),  -- Tango
(14, 14, '2025-01-01', '2025-12-31'),  -- Salsa
(15, 15, '2025-01-01', '2025-12-31'),  -- Merengue
(16, 16, '2025-01-01', '2025-12-31'),  -- Kizomba
(17, 17, '2025-01-01', '2025-12-31'),  -- Lambada
(18, 18, '2025-01-01', '2025-12-31'),  -- Rockabilly
(19, 19, '2025-01-01', '2025-12-31'),  -- Swing
(20, 20, '2025-01-01', '2025-12-31'),  -- Lindy Hop
(21, 21, '2025-01-01', '2025-12-31'),  -- Popping
(22, 22, '2025-01-01', '2025-12-31'),  -- Locking
(23, 23, '2025-01-01', '2025-12-31'),  -- Waacking
(24, 24, '2025-01-01', '2025-12-31'),  -- Vogue
(25, 25, '2025-01-01', '2025-12-31'),  -- House
(26, 26, '2025-01-01', '2025-12-31'),  -- Dancehall
(27, 27, '2025-01-01', '2025-12-31'),  -- Afrobeat
(28, 28, '2025-01-01', '2025-12-31'),  -- Jazz Funk
(29, 29, '2025-01-01', '2025-12-31'),  -- Heels
(30, 30, '2025-01-01', '2025-12-31'),  -- Stiletto
(31, 31, '2025-01-01', '2025-12-31'),  -- Pole Dance
(32, 32, '2025-01-01', '2025-12-31'),  -- Dança Afro
(33, 33, '2025-01-01', '2025-12-31'),  -- Dança Cigana
(34, 34, '2025-01-01', '2025-12-31'),  -- Dança Indiana
(35, 35, '2025-01-01', '2025-12-31'),  -- Dança Irlandesa
(36, 36, '2025-01-01', '2025-12-31'),  -- Dança Havaiana
(37, 37, '2025-01-01', '2025-12-31'),  -- Dança Gaúcha
(38, 38, '2025-01-01', '2025-12-31'),  -- Dança Grega
(39, 39, '2025-01-01', '2025-12-31'),  -- Dança Italiana
(40, 40, '2025-01-01', '2025-12-31'),  -- Dança Russa
(41, 41, '2025-01-01', '2025-12-31'),  -- Dança Ucraniana
(42, 42, '2025-01-01', '2025-12-31'),  -- Dança Polonesa
(43, 43, '2025-01-01', '2025-12-31'),  -- Dança Alemã
(44, 44, '2025-01-01', '2025-12-31'),  -- Dança Francesa
(45, 45, '2025-01-01', '2025-12-31');  -- Dança Árabe

INSERT INTO sala_equipamento (id_equipamento, id_sala, quantidade) VALUES
(2, 2, 2),    -- Espelho de parede, Sala de Ballet
(1, 2, 1),    -- Barra de ballet, Sala de Ballet
(29, 2, 20),  -- Sapatilhas de ballet, Sala de Ballet
(3, 3, 2),    -- Caixa de som profissional, Sala de Dança de Salão
(25, 3, 10),  -- Chapéus para dança de salão, Sala de Dança de Salão
(4, 4, 1),    -- Piso flutuante para dança, Sala Contemporânea
(36, 4, 4),   -- Fitas de led para dança contemporânea, Sala Contemporânea
(3, 5, 2),    -- Caixa de som profissional, Sala Street Dance
(6, 5, 4),    -- Luz cênica para palco, Sala Street Dance
(23, 5, 10),  -- Leques de dança, Sala Street Dance
(31, 5, 8),   -- Cintos de moedas para dança do ventre, Sala Street Dance
(35, 5, 8),   -- Bastão de dança do ventre, Sala Street Dance
(16, 6, 5),   -- Banco para alongamento, Sala Jazz
(2, 6, 1),    -- Espelho de parede, Sala Jazz
(5, 7, 2),    -- Tapete de sapateado, Sala Sapateado
(28, 7, 10),  -- Sapatos de sapateado, Sala Sapateado
(34, 8, 8),   -- Castanholas, Sala Flamenco
(3, 9, 1),    -- Caixa de som profissional, Sala Forró
(3, 10, 1),   -- Caixa de som profissional, Sala Samba
(25, 10, 10), -- Chapéus para dança de salão, Sala Samba
(3, 11, 1),   -- Caixa de som profissional, Sala Zouk
(3, 12, 1),   -- Caixa de som profissional, Sala Bolero
(3, 13, 1),   -- Caixa de som profissional, Sala Tango
(3, 14, 1),   -- Caixa de som profissional, Sala Salsa
(3, 15, 1),   -- Caixa de som profissional, Sala Merengue
(3, 16, 1),   -- Caixa de som profissional, Sala Kizomba
(3, 17, 1),   -- Caixa de som profissional, Sala Lambada
(3, 18, 1),   -- Caixa de som profissional, Sala Rockabilly
(3, 19, 1),   -- Caixa de som profissional, Sala Swing
(3, 20, 1),   -- Caixa de som profissional, Sala Lindy Hop
(3, 21, 1),   -- Caixa de som profissional, Sala Popping
(3, 22, 1),   -- Caixa de som profissional, Sala Locking
(3, 23, 1),   -- Caixa de som profissional, Sala Waacking
(3, 24, 1),   -- Caixa de som profissional, Sala Vogue
(3, 25, 1),   -- Caixa de som profissional, Sala House
(3, 26, 1),   -- Caixa de som profissional, Sala Dancehall
(37, 27, 6),  -- Kit de adereços para dança afro, Sala Afrobeat
(16, 28, 3),  -- Banco para alongamento, Sala Jazz Funk
(26, 29, 10), -- Luvas para jazz, Sala Heels
(26, 30, 10), -- Luvas para jazz, Sala Stiletto
(10, 31, 8),  -- Colchonete de alongamento, Sala Pole
(37, 32, 6),  -- Kit de adereços para dança afro, Sala Afro
(33, 33, 8),  -- Pandeiros para dança cigana, Sala Cigana
(24, 34, 8),  -- Sombrinhas de frevo, Sala Indiana
(30, 35, 8),  -- Tacos de dança irlandesa, Sala Irlandesa
(39, 36, 8),  -- Bastão de fitas, Sala Havaiana
(27, 8, 8),   -- Saias de dança flamenca, Sala Flamenco
(25, 37, 8),  -- Chapéus para dança de salão, Sala Gaúcha
(24, 38, 8),  -- Sombrinhas de frevo, Sala Grega
(24, 39, 8),  -- Sombrinhas de frevo, Sala Italiana
(24, 40, 8),  -- Sombrinhas de frevo, Sala Russa
(24, 41, 8),  -- Sombrinhas de frevo, Sala Ucraniana
(24, 42, 8),  -- Sombrinhas de frevo, Sala Polonesa
(24, 43, 8),  -- Sombrinhas de frevo, Sala Alemã
(24, 44, 8),  -- Sombrinhas de frevo, Sala Francesa
(35, 45, 8);  -- Bastão de dança do ventre, Sala Árabe

-- Tabela sala_modalidade: associa cada modalidade à sala mais coerente

INSERT INTO sala_modalidade (id_sala, id_modalidade) VALUES
(2, 1),    -- Ballet
(3, 2),    -- Dança de Salão
(4, 3),    -- Dança Contemporânea
(5, 4),    -- Street Dance
(5, 5),    -- Dança do Ventre
(6, 6),    -- Jazz
(7, 7),    -- Sapateado
(8, 8),    -- Flamenco
(9, 9),    -- Forró
(10, 10),  -- Samba de Gafieira
(11, 11),  -- Zouk
(12, 12),  -- Bolero
(13, 13),  -- Tango
(14, 14),  -- Salsa
(15, 15),  -- Merengue
(16, 16),  -- Kizomba
(17, 17),  -- Lambada
(18, 18),  -- Rockabilly
(19, 19),  -- Swing
(20, 20),  -- Lindy Hop
(21, 21),  -- Popping
(22, 22),  -- Locking
(23, 23),  -- Waacking
(24, 24),  -- Vogue
(25, 25),  -- House Dance
(26, 26),  -- Dancehall
(27, 27),  -- Afrobeat
(28, 28),  -- Jazz Funk
(29, 29),  -- Heels
(30, 30),  -- Stiletto
(31, 31),  -- Pole Dance
(32, 32),  -- Dança Afro
(33, 33),  -- Dança Cigana
(34, 34),  -- Dança Indiana
(35, 35),  -- Dança Irlandesa
(36, 36),  -- Dança Havaiana
(8, 37),   -- Dança Flamenca (Flamenco)
(37, 38),  -- Dança Gaúcha
(38, 39),  -- Dança Grega
(39, 40),  -- Dança Italiana
(40, 41),  -- Dança Russa
(41, 42),  -- Dança Ucraniana
(42, 43),  -- Dança Polonesa
(43, 44),  -- Dança Alemã
(44, 45),  -- Dança Francesa
(45, 46),  -- Dança Árabe
(1, 47);   -- Dança Chinesa (Estúdio Principal, genérica)


INSERT INTO "campeonato"
  ("data",  "id", "sala", "categoria", "premiacao", "valor_premiacao", "status")
VALUES
  ('2025-02-15 10:00:00', '1', 1, 'Solo',   'Troféu',   100.0, 'Agendado'),
  ('2025-04-20 14:00:00', '2', 2, 'Dueto',  'Medalha',  150.0, 'Agendado'),
  ('2025-06-30 09:00:00', '3', 3, 'Grupo',  'Dinheiro', 200.0, 'Agendado'),
  ('2025-09-05 16:00:00', '4', 1, 'Solo',   'Voucher',  120.0, 'Agendado'),
  ('2025-11-18 13:00:00', '5', 2, 'Grupo',  'Dinheiro', 250.0, 'Agendado');


  INSERT INTO "inscricao"
  ("taxa", "data_insc", "id_transacao", "id_campeonato", "cpf_aluno")
VALUES
  (45.00, '2025-01-10', 1, 1, '20000000040'),
  (48.00, '2025-01-10', 2, 1, '20000000001'),
  (50.00, '2025-01-11', 3, 1, '20000000002'),
  (30.00, '2025-01-12', 4, 1, '20000000003'),
  (20.00, '2025-01-13', 5, 1, '20000000004'),
  (25.00, '2025-03-01', 6, 2, '20000000005'),
  (44.00, '2025-03-01', 7, 2, '20000000006'),
  (35.00, '2025-03-02', 8, 2, '20000000007'),
  (50.00, '2025-03-03', 9, 2, '20000000008'),
  (47.00, '2025-03-04',10, 2, '20000000009'),
  (32.00, '2025-05-01',11, 3, '20000000010'),
  (36.00, '2025-05-01',12, 3, '20000000011'),
  (50.00, '2025-05-01',13, 3, '20000000012'),
  (28.00, '2025-05-02',14, 3, '20000000013'),
  (45.00, '2025-05-03',15, 3, '20000000014'),
  (22.00, '2025-07-20',16, 4, '10000000001'),
  (39.00, '2025-07-21',17, 4, '10000000002'),
  (30.00, '2025-07-22',18, 4, '10000000003'),
  (46.00, '2025-07-23',19, 4, '10000000004'),
  (50.00, '2025-07-24',20, 4, '10000000005'),
  (40.00, '2025-10-10',21, 5, '10000000006'),
  (38.00, '2025-10-11',22, 5, '10000000007'),
  (29.00, '2025-10-12',23, 5, '10000000008'),
  (33.00, '2025-10-13',24, 5, '10000000009'),
  (49.00, '2025-10-14',25, 5, '10000000010'),
  (27.00, '2025-10-15',26, 5, '20000000015'),
  (23.00, '2025-10-16',27, 5, '20000000016'),
  (36.00, '2025-10-17',28, 5, '20000000017'),
  (31.00, '2025-10-18',29, 5, '20000000018'),
  (45.00, '2025-10-19',30, 5, '20000000019');
