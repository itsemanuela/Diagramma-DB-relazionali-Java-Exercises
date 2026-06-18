CREATE TABLE "Eventi"(
    "ID (PK)" BIGINT NOT NULL,
    "titolo_evento" VARCHAR(255) NOT NULL,
    "data_evento" DATE NOT NULL,
    "descrizione" VARCHAR(255) NOT NULL,
    "tipo_evento" VARCHAR(255) CHECK
        ("tipo_evento" IN('')) NOT NULL,
        "location_id (FK)" BIGINT NULL,
        "numero_max_partecipanti" INTEGER NOT NULL
);
ALTER TABLE
    "Eventi" ADD PRIMARY KEY("ID (PK)");
CREATE TABLE "Location"(
    "id (PK)" BIGINT NOT NULL,
    "name_location" VARCHAR(255) NOT NULL,
    "city" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Location" ADD PRIMARY KEY("id (PK)");
CREATE TABLE "Persona"(
    "id (PK)" BIGINT NOT NULL,
    "nome" VARCHAR(255) NOT NULL,
    "cognome" VARCHAR(255) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "data_di_nascita" DATE NOT NULL,
    "sessoMF" VARCHAR(255) NOT NULL,
    "lista_partecipazioni" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Persona" ADD PRIMARY KEY("id (PK)");
CREATE TABLE "Partecipazioni"(
    "id" BIGINT NOT NULL,
    "persona_id (FK)" BIGINT NOT NULL,
    "evento_id (FK)" BIGINT NOT NULL,
    "stato" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "Partecipazioni" ADD PRIMARY KEY("id");
CREATE TABLE "PartitaCalcio"(
    "id" BIGINT NOT NULL,
    "squadra_casa" VARCHAR(255) NOT NULL,
    "squadra_ospite" VARCHAR(255) NOT NULL,
    "squadra_vincente" VARCHAR(255) NOT NULL,
    "n_gol_casa" INTEGER NOT NULL,
    "n_gol_ospite" INTEGER NOT NULL
);
ALTER TABLE
    "PartitaCalcio" ADD PRIMARY KEY("id");
CREATE TABLE "GaraAtletica"(
    "id" BIGINT NOT NULL,
    "set_atleti" VARCHAR(255) NOT NULL,
    "vincitore" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "GaraAtletica" ADD PRIMARY KEY("id");
CREATE TABLE "Concerto"(
    "id" BIGINT NOT NULL,
    "genere" VARCHAR(255) CHECK
        ("genere" IN('')) NOT NULL,
        "in_streaming" BOOLEAN NOT NULL
);
ALTER TABLE
    "Concerto" ADD PRIMARY KEY("id");
ALTER TABLE
    "Eventi" ADD CONSTRAINT "eventi_id (pk)_foreign" FOREIGN KEY("ID (PK)") REFERENCES "Concerto"("id");
ALTER TABLE
    "Partecipazioni" ADD CONSTRAINT "partecipazioni_id_foreign" FOREIGN KEY("id") REFERENCES "Eventi"("ID (PK)");
ALTER TABLE
    "Partecipazioni" ADD CONSTRAINT "partecipazioni_id_foreign" FOREIGN KEY("id") REFERENCES "Persona"("id (PK)");
ALTER TABLE
    "Eventi" ADD CONSTRAINT "eventi_id (pk)_foreign" FOREIGN KEY("ID (PK)") REFERENCES "PartitaCalcio"("id");
ALTER TABLE
    "Eventi" ADD CONSTRAINT "eventi_id (pk)_foreign" FOREIGN KEY("ID (PK)") REFERENCES "GaraAtletica"("id");
ALTER TABLE
    "Eventi" ADD CONSTRAINT "eventi_location_id (fk)_foreign" FOREIGN KEY("location_id (FK)") REFERENCES "Location"("id (PK)");