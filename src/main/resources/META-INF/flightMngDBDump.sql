PGDMP     *                	    w            tpFlightMng    12.0    12.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    18715    tpFlightMng    DATABASE     �   CREATE DATABASE "tpFlightMng" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';
    DROP DATABASE "tpFlightMng";
                postgres    false            �            1259    18718    flight    TABLE       CREATE TABLE public.flight (
    id bigint NOT NULL,
    departuredate date,
    departuretown character varying(255),
    destination character varying(255),
    maxcapacity integer,
    number character varying(255),
    planemodel character varying(255)
);
    DROP TABLE public.flight;
       public         heap    postgres    false            �            1259    18716    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            �            1259    18726    reservation    TABLE     �   CREATE TABLE public.reservation (
    id bigint NOT NULL,
    age integer,
    firstname character varying(255),
    lastname character varying(255),
    number character varying(255),
    flight_id bigint
);
    DROP TABLE public.reservation;
       public         heap    postgres    false                      0    18718    flight 
   TABLE DATA           p   COPY public.flight (id, departuredate, departuretown, destination, maxcapacity, number, planemodel) FROM stdin;
    public          postgres    false    203                    0    18726    reservation 
   TABLE DATA           V   COPY public.reservation (id, age, firstname, lastname, number, flight_id) FROM stdin;
    public          postgres    false    204   �                  0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 6, true);
          public          postgres    false    202            �
           2606    18725    flight flight_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.flight
    ADD CONSTRAINT flight_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.flight DROP CONSTRAINT flight_pkey;
       public            postgres    false    203            �
           2606    18733    reservation reservation_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT reservation_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.reservation DROP CONSTRAINT reservation_pkey;
       public            postgres    false    204            �
           2606    18735 #   flight uk_kgnb50dgafv7ys8vo0wx3ybxs 
   CONSTRAINT     `   ALTER TABLE ONLY public.flight
    ADD CONSTRAINT uk_kgnb50dgafv7ys8vo0wx3ybxs UNIQUE (number);
 M   ALTER TABLE ONLY public.flight DROP CONSTRAINT uk_kgnb50dgafv7ys8vo0wx3ybxs;
       public            postgres    false    203            �
           2606    18737 (   reservation uk_l0859cwm4ueky1l8avwinogjf 
   CONSTRAINT     e   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT uk_l0859cwm4ueky1l8avwinogjf UNIQUE (number);
 R   ALTER TABLE ONLY public.reservation DROP CONSTRAINT uk_l0859cwm4ueky1l8avwinogjf;
       public            postgres    false    204            �
           2606    18738 '   reservation fkhyboj5qkwsttdj9lqcvc853tw    FK CONSTRAINT     �   ALTER TABLE ONLY public.reservation
    ADD CONSTRAINT fkhyboj5qkwsttdj9lqcvc853tw FOREIGN KEY (flight_id) REFERENCES public.flight(id);
 Q   ALTER TABLE ONLY public.reservation DROP CONSTRAINT fkhyboj5qkwsttdj9lqcvc853tw;
       public          postgres    false    203    2694    204               �   x�u�1�0���\ d;)b�X�J0����* ��]�N#�K~�_����:����kq�w8�u�m� ,?vI#b)�i�P�̆��Q,6�o�ǘ�!��K�@�]���k���ժYϴ6�V,���v��ᴚf6�} �-�            x������ � �     