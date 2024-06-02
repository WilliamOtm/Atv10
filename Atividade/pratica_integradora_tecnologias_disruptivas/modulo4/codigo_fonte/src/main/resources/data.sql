-- Inserindo categorias iniciais
INSERT INTO categoria (categoria_id, categoria_nome) VALUES (1, 'Informática');
INSERT INTO categoria (categoria_id, categoria_nome) VALUES (2, 'Celulares');

-- Inserindo produtos iniciais
INSERT INTO produto (produto_id, produto_nome, categoria_id) VALUES (1, 'Notebook DELL', 1);
INSERT INTO produto (produto_id, produto_nome, categoria_id) VALUES (2, 'Samsung Galaxy', 2);

-- Inserindo produtos adicionais
INSERT INTO produto (produto_id, produto_nome, categoria_id) VALUES (3, 'Notebook ACER', 1);
INSERT INTO produto (produto_id, produto_nome, categoria_id) VALUES (4, 'IphoneXR', 2);
