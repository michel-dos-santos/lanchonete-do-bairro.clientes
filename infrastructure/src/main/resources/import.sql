-- CLIENTES
INSERT INTO public.tb_client (id, cpf, created_at, email, "name", updated_at) VALUES('846f7ede-dd90-497e-83a4-4878718ebd03'::uuid, '64115683082', '2023-12-24 16:18:55.198', 'joao.de.souza@gmail.com', 'João de Souza', '2023-12-24 16:18:55.198') ON CONFLICT (id) DO NOTHING;