
IF DB_ID('bdalumno') IS NULL
    CREATE DATABASE bdalumno;
GO

USE bdalumno;
GO

IF OBJECT_ID('dbo.tcurso', 'U') IS NULL
BEGIN
    CREATE TABLE dbo.tcurso (
        id      INT IDENTITY(1,1) NOT NULL,
        CodCur  INT               NOT NULL,
        NomCur  VARCHAR(50)       NOT NULL,
        Ciclo   VARCHAR(4)        NOT NULL,
        NumCre  INT               NOT NULL,
        CONSTRAINT pk_tcurso PRIMARY KEY (id),
        CONSTRAINT uq_tcurso_codcur UNIQUE (CodCur)
    );
END
GO

IF NOT EXISTS (SELECT 1 FROM dbo.tcurso)
BEGIN
    INSERT INTO dbo.tcurso (CodCur, NomCur, Ciclo, NumCre) VALUES
        (1001, N'Ingeniería de Software',            'VI',  4),
        (1002, N'Base de Datos',                     'IV',  4),
        (1003, N'Programación Orientada a Objetos',  'III', 3),
        (1004, N'Matemática Discreta',               'II',  3),
        (1005, N'Redes de Computadoras',             'V',   3);
END
GO

-- 4. Para revisar:
SELECT * FROM dbo.tcurso;
GO
