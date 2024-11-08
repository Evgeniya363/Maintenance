--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Name: company; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.company (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.company OWNER TO postgres;

--
-- Name: contractor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contractor (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    employee_id bigint
);


ALTER TABLE public.contractor OWNER TO postgres;

--
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    name character varying(255) NOT NULL,
    company_id bigint
);


ALTER TABLE public.department OWNER TO postgres;

--
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    first_name character varying(255) NOT NULL,
    patronymic character varying(255),
    second_name character varying(255) NOT NULL,
    department_id bigint,
    post_id bigint
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- Name: equipment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.equipment (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    inventory_number character varying(255),
    maintenance_date date,
    serial_number character varying(255),
    service_number character varying(255) NOT NULL,
    start_usage_date date,
    category_id bigint,
    department_id bigint,
    employee_id bigint,
    model_id bigint
);


ALTER TABLE public.equipment OWNER TO postgres;

--
-- Name: id_sequence_generator; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.id_sequence_generator
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.id_sequence_generator OWNER TO postgres;

--
-- Name: maintenance; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.maintenance (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    date date NOT NULL,
    reason character varying(255),
    status integer,
    type integer,
    contractor_id bigint,
    equipment_id bigint
);


ALTER TABLE public.maintenance OWNER TO postgres;

--
-- Name: malfunction; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.malfunction (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    name character varying(255) NOT NULL,
    spare_parts character varying(255),
    troubleshooting character varying(255),
    maintenance_id bigint NOT NULL
);


ALTER TABLE public.malfunction OWNER TO postgres;

--
-- Name: manufacturer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.manufacturer (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.manufacturer OWNER TO postgres;

--
-- Name: model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.model (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    name character varying(255) NOT NULL,
    manufacturer_id bigint
);


ALTER TABLE public.model OWNER TO postgres;

--
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.post (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone NOT NULL,
    modify_at timestamp(6) without time zone NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.post OWNER TO postgres;

--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (id, created_at, modify_at, name) FROM stdin;
19	2024-11-08 19:53:37.613185	2024-11-08 19:53:37.613185	Computer
20	2024-11-08 19:53:37.619185	2024-11-08 19:53:37.619185	Printer
21	2024-11-08 19:53:37.623185	2024-11-08 19:53:37.623185	Display
\.


--
-- Data for Name: company; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.company (id, created_at, modify_at, name) FROM stdin;
4	2024-11-08 19:53:37.542637	2024-11-08 19:53:37.542637	IT Service Center
5	2024-11-08 19:53:37.546637	2024-11-08 19:53:37.546637	Company1
6	2024-11-08 19:53:37.550667	2024-11-08 19:53:37.550667	Company2
\.


--
-- Data for Name: contractor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contractor (id, created_at, modify_at, employee_id) FROM stdin;
27	2024-11-08 19:53:37.652722	2024-11-08 19:53:37.652722	22
28	2024-11-08 19:53:37.657722	2024-11-08 19:53:37.657722	23
\.


--
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.department (id, created_at, modify_at, name, company_id) FROM stdin;
7	2024-11-08 19:53:37.555185	2024-11-08 19:53:37.555185	Department1	4
8	2024-11-08 19:53:37.559185	2024-11-08 19:53:37.559185	Department2	5
9	2024-11-08 19:53:37.563186	2024-11-08 19:53:37.563186	Department3	5
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employee (id, created_at, modify_at, first_name, patronymic, second_name, department_id, post_id) FROM stdin;
22	2024-11-08 19:53:37.628185	2024-11-08 19:53:37.628185	Ivan	Iv.	Ivanov	7	2
23	2024-11-08 19:53:37.633723	2024-11-08 19:53:37.633723	Petr	Pt.	Petrov	7	3
24	2024-11-08 19:53:37.638722	2024-11-08 19:53:37.638722	Alla	Dm.	Koval	8	1
25	2024-11-08 19:53:37.642722	2024-11-08 19:53:37.642722	Inna	Iv.	Golovina	9	2
26	2024-11-08 19:53:37.647722	2024-11-08 19:53:37.647722	Zoya	Pl.	Kostenko	9	3
\.


--
-- Data for Name: equipment; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.equipment (id, created_at, modify_at, inventory_number, maintenance_date, serial_number, service_number, start_usage_date, category_id, department_id, employee_id, model_id) FROM stdin;
29	2024-11-08 19:53:37.705727	2024-11-08 19:53:37.705727	2200001	2024-03-27	123-34521-123hj-123-00	300-001	2017-11-10	19	9	24	15
30	2024-11-08 19:53:37.734722	2024-11-08 19:53:37.734722	2200001	2023-12-30	123-34521-123hj-123-00	300-001	2017-08-06	20	8	23	16
31	2024-11-08 19:53:37.759719	2024-11-08 19:53:37.759719	2200001	2024-03-26	123-34521-123hj-123-00	300-001	2017-09-10	21	8	24	14
32	2024-11-08 19:53:37.784723	2024-11-08 19:53:37.785722	2200001	2024-10-07	123-34521-123hj-123-00	300-001	2019-02-27	19	8	25	15
33	2024-11-08 19:53:37.80972	2024-11-08 19:53:37.80972	2200001	2024-10-19	123-34521-123hj-123-00	300-001	2017-10-21	20	8	22	14
34	2024-11-08 19:53:37.834719	2024-11-08 19:53:37.834719	2200001	2024-06-19	123-34521-123hj-123-00	300-001	2022-11-23	19	9	26	16
35	2024-11-08 19:53:37.858719	2024-11-08 19:53:37.858719	2200001	2024-06-21	123-34521-123hj-123-00	300-001	2019-06-27	19	8	24	14
36	2024-11-08 19:53:37.886722	2024-11-08 19:53:37.886722	2200001	2024-01-05	123-34521-123hj-123-00	300-001	2016-08-03	19	7	23	14
37	2024-11-08 19:53:37.911723	2024-11-08 19:53:37.911723	2200001	2024-09-09	123-34521-123hj-123-00	300-001	2019-06-27	21	9	25	15
38	2024-11-08 19:53:37.935722	2024-11-08 19:53:37.935722	2200001	2024-05-03	123-34521-123hj-123-00	300-001	2017-05-26	19	9	25	14
\.


--
-- Data for Name: maintenance; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.maintenance (id, created_at, modify_at, date, reason, status, type, contractor_id, equipment_id) FROM stdin;
39	2024-11-08 19:53:37.981726	2024-11-08 19:53:37.981726	2023-01-27	Comment#1	2	1	28	29
40	2024-11-08 19:53:37.989721	2024-11-08 19:53:37.989721	2024-01-27	Comment#96	2	0	27	29
41	2024-11-08 19:53:37.998725	2024-11-08 19:53:37.998725	2023-07-11	Comment#41	2	1	28	30
42	2024-11-08 19:53:38.007727	2024-11-08 19:53:38.007727	2024-07-10	Comment#76	2	0	28	30
43	2024-11-08 19:53:38.015724	2024-11-08 19:53:38.015724	2023-03-03	Comment#5	2	0	27	31
44	2024-11-08 19:53:38.051721	2024-11-08 19:53:38.051721	2024-03-02	Comment#15	1	0	28	31
45	2024-11-08 19:53:38.057722	2024-11-08 19:53:38.057722	2023-09-26	Comment#42	2	1	28	32
46	2024-11-08 19:53:38.064723	2024-11-08 19:53:38.064723	2024-09-25	Comment#56	0	0	28	32
47	2024-11-08 19:53:38.072721	2024-11-08 19:53:38.072721	2023-02-01	Comment#96	2	0	28	33
48	2024-11-08 19:53:38.078722	2024-11-08 19:53:38.078722	2024-02-01	Comment#59	0	1	27	33
49	2024-11-08 19:53:38.084721	2024-11-08 19:53:38.084721	2023-09-27	Comment#31	2	0	28	34
50	2024-11-08 19:53:38.09072	2024-11-08 19:53:38.09072	2024-09-26	Comment#6	2	1	28	34
51	2024-11-08 19:53:38.097721	2024-11-08 19:53:38.097721	2023-01-18	Comment#94	2	1	27	35
52	2024-11-08 19:53:38.103722	2024-11-08 19:53:38.103722	2024-01-18	Comment#42	1	0	27	35
53	2024-11-08 19:53:38.109722	2024-11-08 19:53:38.109722	2023-09-14	Comment#38	2	1	28	36
54	2024-11-08 19:53:38.11572	2024-11-08 19:53:38.11572	2024-09-13	Comment#90	0	1	27	36
55	2024-11-08 19:53:38.121722	2024-11-08 19:53:38.121722	2023-03-08	Comment#87	2	1	28	37
56	2024-11-08 19:53:38.12872	2024-11-08 19:53:38.12872	2024-03-07	Comment#33	0	0	28	37
57	2024-11-08 19:53:38.134722	2024-11-08 19:53:38.134722	2023-07-10	Comment#86	2	0	27	38
58	2024-11-08 19:53:38.140722	2024-11-08 19:53:38.140722	2024-07-09	Comment#35	0	0	28	38
\.


--
-- Data for Name: malfunction; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.malfunction (id, created_at, modify_at, name, spare_parts, troubleshooting, maintenance_id) FROM stdin;
\.


--
-- Data for Name: manufacturer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.manufacturer (id, created_at, modify_at, name) FROM stdin;
10	2024-11-08 19:53:37.568185	2024-11-08 19:53:37.568185	ASUS
11	2024-11-08 19:53:37.573185	2024-11-08 19:53:37.573185	HP
12	2024-11-08 19:53:37.577186	2024-11-08 19:53:37.577186	None
13	2024-11-08 19:53:37.581184	2024-11-08 19:53:37.581184	Samsung
\.


--
-- Data for Name: model; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.model (id, created_at, modify_at, name, manufacturer_id) FROM stdin;
14	2024-11-08 19:53:37.586185	2024-11-08 19:53:37.586185	S1024U	10
15	2024-11-08 19:53:37.590184	2024-11-08 19:53:37.590184	A124U	10
16	2024-11-08 19:53:37.595184	2024-11-08 19:53:37.595184	AI-15	11
17	2024-11-08 19:53:37.601185	2024-11-08 19:53:37.601185	FF140	11
18	2024-11-08 19:53:37.607186	2024-11-08 19:53:37.607186	Star 5	12
\.


--
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.post (id, created_at, modify_at, name) FROM stdin;
1	2024-11-08 19:53:37.517684	2024-11-08 19:53:37.518671	accountant
2	2024-11-08 19:53:37.533639	2024-11-08 19:53:37.533639	engineer
3	2024-11-08 19:53:37.537636	2024-11-08 19:53:37.537636	technician
\.


--
-- Name: id_sequence_generator; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.id_sequence_generator', 58, true);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: company company_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.company
    ADD CONSTRAINT company_pkey PRIMARY KEY (id);


--
-- Name: contractor contractor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contractor
    ADD CONSTRAINT contractor_pkey PRIMARY KEY (id);


--
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: equipment equipment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT equipment_pkey PRIMARY KEY (id);


--
-- Name: maintenance maintenance_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maintenance
    ADD CONSTRAINT maintenance_pkey PRIMARY KEY (id);


--
-- Name: malfunction malfunction_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.malfunction
    ADD CONSTRAINT malfunction_pkey PRIMARY KEY (id);


--
-- Name: manufacturer manufacturer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.manufacturer
    ADD CONSTRAINT manufacturer_pkey PRIMARY KEY (id);


--
-- Name: model model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT model_pkey PRIMARY KEY (id);


--
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);


--
-- Name: maintenance fk2aup8ahw6qoupvcgcktsjdvbf; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maintenance
    ADD CONSTRAINT fk2aup8ahw6qoupvcgcktsjdvbf FOREIGN KEY (equipment_id) REFERENCES public.equipment(id);


--
-- Name: model fk3q3dd1gats5au027tbdy4upfi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.model
    ADD CONSTRAINT fk3q3dd1gats5au027tbdy4upfi FOREIGN KEY (manufacturer_id) REFERENCES public.manufacturer(id);


--
-- Name: maintenance fk4otxh2qoih70rawo9e4kv8h06; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.maintenance
    ADD CONSTRAINT fk4otxh2qoih70rawo9e4kv8h06 FOREIGN KEY (contractor_id) REFERENCES public.contractor(id);


--
-- Name: equipment fkb4svnpl9s3b1p5uuvqx5ihlki; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT fkb4svnpl9s3b1p5uuvqx5ihlki FOREIGN KEY (category_id) REFERENCES public.category(id);


--
-- Name: employee fkbejtwvg9bxus2mffsm3swj3u9; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkbejtwvg9bxus2mffsm3swj3u9 FOREIGN KEY (department_id) REFERENCES public.department(id);


--
-- Name: contractor fkcaqedewttdcxmy4kudj7a4h2p; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contractor
    ADD CONSTRAINT fkcaqedewttdcxmy4kudj7a4h2p FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: employee fkcm3b9d5fiw8s6co7lkw8c0lbs; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fkcm3b9d5fiw8s6co7lkw8c0lbs FOREIGN KEY (post_id) REFERENCES public.post(id);


--
-- Name: equipment fkdaa1vqflnntgppniar3ga738m; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT fkdaa1vqflnntgppniar3ga738m FOREIGN KEY (department_id) REFERENCES public.department(id);


--
-- Name: equipment fkf2ffo63vgd3hwnef2u9h06ii2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT fkf2ffo63vgd3hwnef2u9h06ii2 FOREIGN KEY (employee_id) REFERENCES public.employee(id);


--
-- Name: equipment fkgfycjdthonudivh0bqj65ewcp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.equipment
    ADD CONSTRAINT fkgfycjdthonudivh0bqj65ewcp FOREIGN KEY (model_id) REFERENCES public.model(id);


--
-- Name: department fkh1m88q0f7sc0mk76kju4kcn6f; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT fkh1m88q0f7sc0mk76kju4kcn6f FOREIGN KEY (company_id) REFERENCES public.company(id);


--
-- Name: malfunction fkstociwpjlnl71s5cqjacnccjd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.malfunction
    ADD CONSTRAINT fkstociwpjlnl71s5cqjacnccjd FOREIGN KEY (maintenance_id) REFERENCES public.maintenance(id);


--
-- PostgreSQL database dump complete
--

