PGDMP         9                {         	   phonebook    14.5    15.0 %    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16707 	   phonebook    DATABASE     }   CREATE DATABASE phonebook WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1251';
    DROP DATABASE phonebook;
                mike    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                mike    false            ?           0    0    SCHEMA public    ACL     Q   REVOKE USAGE ON SCHEMA public FROM PUBLIC;
GRANT ALL ON SCHEMA public TO PUBLIC;
                   mike    false    4            ?            1259    16723    additional_info    TABLE     ?   CREATE TABLE public.additional_info (
    add_id smallint NOT NULL,
    "peoples_id_add_SK" smallint,
    add_info character varying(100)
);
 #   DROP TABLE public.additional_info;
       public         heap    mike    false    4            ?            1259    16722    additional_info_add_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.additional_info_add_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.additional_info_add_id_seq;
       public          mike    false    214    4            ?           0    0    additional_info_add_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.additional_info_add_id_seq OWNED BY public.additional_info.add_id;
          public          mike    false    213            ?            1259    16730    email_address    TABLE     ?   CREATE TABLE public.email_address (
    email_id smallint NOT NULL,
    "peoples_email_SK" smallint,
    email character varying(100)
);
 !   DROP TABLE public.email_address;
       public         heap    mike    false    4            ?            1259    16729    email_adress_email_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.email_adress_email_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.email_adress_email_id_seq;
       public          mike    false    216    4            ?           0    0    email_adress_email_id_seq    SEQUENCE OWNED BY     X   ALTER SEQUENCE public.email_adress_email_id_seq OWNED BY public.email_address.email_id;
          public          mike    false    215            ?            1259    16709    peoples    TABLE     ?   CREATE TABLE public.peoples (
    peoples_id smallint NOT NULL,
    first_name character varying(50),
    second_name character varying(50),
    father_name character varying(50)
);
    DROP TABLE public.peoples;
       public         heap    mike    false    4            ?            1259    16708    peoples_peoples_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.peoples_peoples_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.peoples_peoples_id_seq;
       public          mike    false    4    210            ?           0    0    peoples_peoples_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.peoples_peoples_id_seq OWNED BY public.peoples.peoples_id;
          public          mike    false    209            ?            1259    16716    phone_numbers    TABLE     ?   CREATE TABLE public.phone_numbers (
    phone_id smallint NOT NULL,
    "peoples_id_SK" smallint,
    phone character varying(20)
);
 !   DROP TABLE public.phone_numbers;
       public         heap    mike    false    4            ?            1259    16715    phone_numbers_phone_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.phone_numbers_phone_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.phone_numbers_phone_id_seq;
       public          mike    false    212    4            ?           0    0    phone_numbers_phone_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.phone_numbers_phone_id_seq OWNED BY public.phone_numbers.phone_id;
          public          mike    false    211                       2604    16726    additional_info add_id    DEFAULT     ?   ALTER TABLE ONLY public.additional_info ALTER COLUMN add_id SET DEFAULT nextval('public.additional_info_add_id_seq'::regclass);
 E   ALTER TABLE public.additional_info ALTER COLUMN add_id DROP DEFAULT;
       public          mike    false    214    213    214                       2604    16733    email_address email_id    DEFAULT        ALTER TABLE ONLY public.email_address ALTER COLUMN email_id SET DEFAULT nextval('public.email_adress_email_id_seq'::regclass);
 E   ALTER TABLE public.email_address ALTER COLUMN email_id DROP DEFAULT;
       public          mike    false    216    215    216                       2604    16712    peoples peoples_id    DEFAULT     x   ALTER TABLE ONLY public.peoples ALTER COLUMN peoples_id SET DEFAULT nextval('public.peoples_peoples_id_seq'::regclass);
 A   ALTER TABLE public.peoples ALTER COLUMN peoples_id DROP DEFAULT;
       public          mike    false    210    209    210                       2604    16719    phone_numbers phone_id    DEFAULT     ?   ALTER TABLE ONLY public.phone_numbers ALTER COLUMN phone_id SET DEFAULT nextval('public.phone_numbers_phone_id_seq'::regclass);
 E   ALTER TABLE public.phone_numbers ALTER COLUMN phone_id DROP DEFAULT;
       public          mike    false    211    212    212            ?          0    16723    additional_info 
   TABLE DATA           P   COPY public.additional_info (add_id, "peoples_id_add_SK", add_info) FROM stdin;
    public          mike    false    214   *       ?          0    16730    email_address 
   TABLE DATA           L   COPY public.email_address (email_id, "peoples_email_SK", email) FROM stdin;
    public          mike    false    216   ?*       ?          0    16709    peoples 
   TABLE DATA           S   COPY public.peoples (peoples_id, first_name, second_name, father_name) FROM stdin;
    public          mike    false    210   
+       ?          0    16716    phone_numbers 
   TABLE DATA           I   COPY public.phone_numbers (phone_id, "peoples_id_SK", phone) FROM stdin;
    public          mike    false    212   ?+       ?           0    0    additional_info_add_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.additional_info_add_id_seq', 21, true);
          public          mike    false    213            ?           0    0    email_adress_email_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.email_adress_email_id_seq', 20, true);
          public          mike    false    215            ?           0    0    peoples_peoples_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.peoples_peoples_id_seq', 52, true);
          public          mike    false    209            ?           0    0    phone_numbers_phone_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.phone_numbers_phone_id_seq', 29, true);
          public          mike    false    211                       2606    16728 $   additional_info additional_info_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.additional_info
    ADD CONSTRAINT additional_info_pkey PRIMARY KEY (add_id);
 N   ALTER TABLE ONLY public.additional_info DROP CONSTRAINT additional_info_pkey;
       public            mike    false    214                       2606    16735    email_address email_adress_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.email_address
    ADD CONSTRAINT email_adress_pkey PRIMARY KEY (email_id);
 I   ALTER TABLE ONLY public.email_address DROP CONSTRAINT email_adress_pkey;
       public            mike    false    216                       2606    16714    peoples peoples_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.peoples
    ADD CONSTRAINT peoples_pkey PRIMARY KEY (peoples_id);
 >   ALTER TABLE ONLY public.peoples DROP CONSTRAINT peoples_pkey;
       public            mike    false    210                       2606    16721     phone_numbers phone_numbers_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.phone_numbers
    ADD CONSTRAINT phone_numbers_pkey PRIMARY KEY (phone_id);
 J   ALTER TABLE ONLY public.phone_numbers DROP CONSTRAINT phone_numbers_pkey;
       public            mike    false    212                       2606    16746 6   additional_info additional_info_peoples_id_add_SK_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.additional_info
    ADD CONSTRAINT "additional_info_peoples_id_add_SK_fkey" FOREIGN KEY ("peoples_id_add_SK") REFERENCES public.peoples(peoples_id);
 b   ALTER TABLE ONLY public.additional_info DROP CONSTRAINT "additional_info_peoples_id_add_SK_fkey";
       public          mike    false    210    3095    214                        2606    16741 0   email_address email_adress_peoples_email_SK_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.email_address
    ADD CONSTRAINT "email_adress_peoples_email_SK_fkey" FOREIGN KEY ("peoples_email_SK") REFERENCES public.peoples(peoples_id);
 \   ALTER TABLE ONLY public.email_address DROP CONSTRAINT "email_adress_peoples_email_SK_fkey";
       public          mike    false    210    3095    216                       2606    16736    phone_numbers peoples_id_SK    FK CONSTRAINT     ?   ALTER TABLE ONLY public.phone_numbers
    ADD CONSTRAINT "peoples_id_SK" FOREIGN KEY ("peoples_id_SK") REFERENCES public.peoples(peoples_id);
 G   ALTER TABLE ONLY public.phone_numbers DROP CONSTRAINT "peoples_id_SK";
       public          mike    false    3095    212    210            ?      x?M̱?@???y?L??? `?????	??6?HP$3???????????I?#?j?*#???ʅ'.H?W>???xT??u?hT??%?]_????t??l?{??ꭃ?CQ?ԩ??????QMr      ?   d   x?3?4??,K??/s?M???+*?2B??Œ?s??9?8RK?????y)? ?&?Ɯř)? Ѥl??9??%?H?8NN?{.v_?}a\8F??? =)p      ?   ?   x?e?9?0E??a[?]8???@?I???%Rr???F??"?,y_?*j<??:??K?7?^?Z?%G1sc? ??h??j??$힄As??\$i??O?^m??w????U??V(M{?f"??Į:?>o?s?ză      ?   j   x?5?A
ADѵu??aJ-??????;\=?"???鑪{??????| [?'?zm?H????~C?)????p??h{???T -?m!???1??M??9????Z#?     