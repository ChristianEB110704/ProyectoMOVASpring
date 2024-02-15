-- DROP DATABASE MOVA;
CREATE DATABASE MOVA;
use MOVA;

create table PERSONAJES(
	id INT primary key,
    nombre varchar(20),
    descripcion varchar(90),
    rol varchar (10)
    
);

CREATE TABLE HABILIDADES(
    id INT PRIMARY KEY,
    id_personaje INT,
    hab_definitiva VARCHAR(50),
    descripcion VARCHAR(500),
    
    FOREIGN KEY (id_personaje) REFERENCES PERSONAJES(id)
);




CREATE TABLE SERVIDORES(
    id INT PRIMARY KEY,
    nombre_servidor VARCHAR(50),
    direccion_ip VARCHAR(30),
    descripcion VARCHAR(80)
);


create table USUARIOS(
	id INT primary key,
    nombre varchar(20),
    servidor int,
    nivel int,
    
    FOREIGN KEY (servidor) REFERENCES SERVIDORES(id)
    
);

create table HISTORIAL(
	id INT primary key,
    id_usuario INT ,
    id_personaje INT ,
    kda INT, 
    /* Aqui crearemos la media del kda de esa partida */
    resultado varchar (1),
    /* V para victoria y D para derrota */
    fecha DATE,
    duracion TIME,
    linea varchar(10),
    /* La linea son: superior, inferior, central ,apoyo y jungla */
    
    FOREIGN KEY (id_usuario) REFERENCES USUARIOS(id),
    FOREIGN KEY (id_personaje) REFERENCES PERSONAJES(id)
    
);
INSERT INTO PERSONAJES (id, nombre, descripcion, rol) VALUES
(1, 'Aatrox', 'La Espada Darkin', 'Luchador'),
(2, 'Ahri', 'La Zorrita Encantadora', 'Asesino'),
(3, 'Ashe', 'La Arquera de Hielo', 'Tirador'),
(4, 'Darius', 'La Mano de Noxus', 'Luchador'),
(5, 'Ekko', 'El Niño que Rompió el Tiempo', 'Asesino'),
(6, 'Fiora', 'La Gran Duelista', 'Luchador'),
(7, 'Garen', 'El Poder de Demacia', 'Tanque'),
(8, 'Jinx', 'La Bala Perdida', 'Tirador'),
(9, 'Katarina', 'La Cuchilla Siniestra', 'Asesino'),
(10, 'Lee Sin', 'El Monje Ciego', 'Luchador'),
(11, 'Lux', 'La Dama Luminosa', 'Mago'),
(12, 'Malphite', 'El Fragmento del Monolito', 'Tanque'),
(13, 'Miss Fortune', 'La Cazarrecompensas', 'Tirador'),
(14, 'Nasus', 'El Curador de las Arenas', 'Luchador'),
(15, 'Orianna', 'El Autómata de las Sombras', 'Mago'),
(16, 'Pyke', 'El Ahogado', 'Soporte'),
(17, 'Riven', 'La Exiliada', 'Luchador'),
(18, 'Soraka', 'La Hija de las Estrellas', 'Soporte'),
(19, 'Talon', 'La Sombra de la Espada', 'Asesino'),
(20, 'Thresh', 'El Carcelero', 'Soporte'),
(21, 'Tristana', 'La Yordle Artillera', 'Tirador'),
(22, 'Twisted Fate', 'El Maestro de las Cartas', 'Mago'),
(23, 'Urgot', 'El Verdugo', 'Luchador'),
(24, 'Vayne', 'La Cazadora Nocturna', 'Tirador'),
(25, 'Veigar', 'El Pequeño Maestro del Mal', 'Mago'),
(26, 'Vi', 'La Jefa de Piltover', 'Luchador'),
(27, 'Xin Zhao', 'El Senescal de Demacia', 'Luchador'),
(28, 'Yasuo', 'El Imperdonable', 'Luchador'),
(29, 'Zed', 'El Maestro de las Sombras', 'Asesino'),
(30, 'Zyra', 'La Flor Letal', 'Mago');

INSERT INTO PERSONAJES (id, nombre, descripcion, rol) VALUES
(31, 'Alistar', 'El Minotauro', 'Tanque'),
(32, 'Annie', 'La Niña Tenebrosa', 'Mago'),
(33, 'Bard', 'El Guardián Errante', 'Soporte'),
(34, 'Camille', 'La Sombra de Acero', 'Luchador'),
(35, 'Draven', 'El Glorioso Ejecutor', 'Tirador'),
(36, 'Ezreal', 'El Explorador Pródigo', 'Tirador'),
(37, 'Fiddlesticks', 'El Espantapájaros Anciano', 'Mago'),
(38, 'Gnar', 'El Eslabón Perdido', 'Luchador'),
(39, 'Hecarim', 'La Sombra de la Guerra', 'Luchador'),
(40, 'Irelia', 'La Danzarina de las Hojas', 'Luchador'),
(41, 'Jhin', 'El Virtuoso', 'Tirador'),
(42, 'Kalista', 'El Espíritu de la Venganza', 'Tirador'),
(43, 'Lulu', 'La Hechicera Hada', 'Soporte'),
(44, 'Mordekaiser', 'El Renacido de Hierro', 'Luchador'),
(45, 'Nami', 'La Dama de las Olas', 'Soporte'),
(46, 'Olaf', 'El Berserker', 'Luchador'),
(47, 'Poppy', 'La Guardiana del Martillo', 'Tanque'),
(48, 'Qiyana', 'La Emperatriz de los Elementos', 'Luchador'),
(49, 'Ryze', 'El Archimago Rúnico', 'Mago'),
(50, 'Sejuani', 'La Furia del Fréljord', 'Tanque'),
(51, 'Shyvana', 'La Hija del Dragón', 'Luchador'),
(52, 'Swain', 'El Gran General Noxiano', 'Mago'),
(53, 'Tahm Kench', 'El Rey del Río', 'Tanque'),
(54, 'Udyr', 'El Espíritu Animal', 'Luchador'),
(55, 'Varus', 'La Flecha de la Venganza', 'Tirador'),
(56, 'Wukong', 'El Rey Mono', 'Luchador'),
(57, 'Xayah', 'La Rebelde', 'Tirador'),
(58, 'Yorick', 'El Pastor de Almas', 'Luchador'),
(59, 'Zilean', 'El Guardián del Tiempo', 'Mago'),
(60, 'Zoe', 'El Aspecto del Crepúsculo', 'Mago');

-- Aatrox
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(1, 1, 'Cadena de las Tinieblas', 'Aatrox libera su espada y realiza un giro mortal, infligiendo daño a todos los enemigos en el área.');

-- Ahri
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(2, 2, 'Espíritus Zorrunos', 'Ahri lanza tres esferas que atraviesan a los enemigos, infligiendo daño mágico y dejando a los enemigos alcanzados vulnerable a su siguiente hechizo.');

-- Ashe
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(3, 3, 'Flecha de la Enfermedad', 'Ashe dispara una flecha global que inflige daño y aturde al objetivo alcanzado.');

-- Darius
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(4, 4, 'Guillotina Noxiana', 'Darius salta hacia un enemigo y realiza un ataque potenciado que inflige daño verdadero.');

-- Ekko
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(5, 5, 'Paradoja Cronológica', 'Ekko regresa a un momento previo en el tiempo, recuperando vida y causando daño a los enemigos cercanos al regresar.');

-- Fiora
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(6, 6, 'Danza de Duelo', 'Fiora realiza una serie de ataques rápidos y precisos, infligiendo daño crítico a su objetivo.');

-- Garen
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(7, 7, 'Juicio', 'Garen realiza un remolino con su espada, infligiendo daño a los enemigos cercanos.');

-- Jinx
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(8, 8, 'Supermegacohete Requetemortal', 'Jinx dispara un cohete global que explota al impactar, infligiendo daño de área.');

-- Katarina
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(9, 9, 'Death Lotus', 'Katarina realiza una ráfaga de cuchillas a su alrededor, infligiendo daño a los enemigos cercanos.');

-- Lee Sin
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(10, 10, 'Patada Relámpago', 'Lee Sin realiza una patada poderosa que envía al objetivo hacia atrás e inflige daño.');

-- Lux
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(11, 11, 'Descarga Final', 'Lux dispara un rayo láser de energía que inflige daño a todos los enemigos en línea recta.');

-- Malphite
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(12, 12, 'Fuerza Imparable', 'Malphite se lanza hacia un enemigo a gran velocidad, infligiendo daño y derribando a los enemigos en su camino.');

-- Miss Fortune
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(13, 13, 'Descarga de Balas', 'Miss Fortune dispara una ráfaga de balas que inflige daño a todos los enemigos en un área con forma de cono.');

-- Nasus
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(14, 14, 'Furia de las Arenas', 'Nasus aumenta su tamaño y poder, infligiendo daño adicional con sus ataques básicos.');

-- Orianna
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(15, 15, 'Onda de Choque', 'Orianna lanza su bola en una ubicación, infligiendo daño y lanzando a los enemigos por el aire.');

-- Pyke
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(16, 16, 'Último Suspiro', 'Pyke salta hacia un área y realiza una ejecución, ejecutando a enemigos con baja salud y compartiendo el oro con sus aliados.');

-- Riven
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(17, 17, 'Cuchillada del Halcón', 'Riven realiza una serie de ataques rápidos y devastadores, infligiendo daño a los enemigos cercanos.');

-- Soraka
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(18, 18, 'Llamada Estelar', 'Soraka invoca una lluvia de estrellas curativas que restaura la salud de los aliados en el área.');

-- Talon
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(19, 19, 'Asalto Sombrío', 'Talon se teletransporta detrás de su objetivo y realiza ataques rápidos, infligiendo daño adicional.');

-- Thresh
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(20, 20, 'Jaula Oscura', 'Thresh crea una prisión de paredes espirituales, ralentizando a los enemigos y capturando a aquellos que permanezcan dentro por demasiado tiempo.');

-- Tristana
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(21, 21, 'Tiro Rápido', 'Tristana aumenta su velocidad de ataque y alcance durante un breve periodo de tiempo.');

-- Twisted Fate
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(22, 22, 'Destino', 'Twisted Fate revela todas las cartas en el mapa, revelando la posición de los enemigos durante un breve periodo de tiempo.');

-- Urgot
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(23, 23, 'Imprecador Noxiano', 'Urgot dispara un rayo químico a un objetivo, infligiendo daño y suprimiéndolo por un tiempo.');

-- Vayne
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(24, 24, 'Caza Nocturna', 'Vayne mejora sus habilidades, aumentando su velocidad de ataque y la posibilidad de dar golpes críticos.');

-- Veigar
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(25, 25, 'Ráfaga Primordial', 'Veigar libera una explosión de energía, infligiendo daño mágico a todos los enemigos en el área.');

-- Vi
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(26, 26, 'Asalto Certero', 'Vi carga hacia un enemigo, infligiendo daño y aturdiéndolo.');

-- Xin Zhao
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(27, 27, 'Asalto Audaz', 'Xin Zhao realiza una serie de ataques rápidos, infligiendo daño y lanzando al último enemigo alcanzado al aire.');

-- Yasuo
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(28, 28, 'Corte del Viento Ígneo', 'Yasuo desata su espada, lanzando a los enemigos al aire y causando daño adicional con sus ataques.');

-- Zed
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(29, 29, 'Marca de la Muerte', 'Zed se teletransporta hacia un enemigo, realizando una ráfaga de ataques y dejando una sombra detrás que puede ser recorrida.');

-- Zyra
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(30, 30, 'Espinas Mortales', 'Zyra crea una zona de enredaderas mortales que infligen daño y ralentizan a los enemigos en el área.');

-- Alistar
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(31, 31, 'Inmolación', 'Alistar canaliza su poder, infligiendo daño a los enemigos cercanos y ganando reducción de daño.');

-- Annie
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(32, 32, 'Invocar Tibbers', 'Annie invoca a Tibbers, un oso de peluche gigante que inflige daño a los enemigos cercanos y permanece en el campo de batalla.');

-- Bard
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(33, 33, 'Viaje Cósmico', 'Bard abre un portal cósmico, permitiendo que su equipo y él viajen rápidamente a otra ubicación.');

-- Camille
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(34, 34, 'Protocolo de Precisión', 'Camille salta hacia un enemigo, infligiendo daño y ralentizándolo. Además, sus ataques básicos infligen daño adicional.');

-- Draven
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(35, 35, 'Tormenta de Hachas', 'Draven lanza hachas giratorias en una dirección, infligiendo daño a los enemigos alcanzados.');

-- Ezreal
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(36, 36, 'Descarga de Poder', 'Ezreal dispara un rayo de energía mágica global que inflige daño a todos los enemigos en línea recta.');

-- Fiddlesticks
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(37, 37, 'Tormenta de Cuervos', 'Fiddlesticks invoca una tormenta de cuervos que inflige daño a los enemigos en un área.');

-- Gnar
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(38, 38, 'Choque Cósmico', 'Gnar salta hacia un área, infligiendo daño y aturdiendo a los enemigos cercanos.');

-- Hecarim
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(39, 39, 'Carga Devastadora', 'Hecarim carga hacia un enemigo, infligiendo daño y temor a los enemigos en su camino.');

-- Irelia
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(40, 40, 'Embestida Definitiva', 'Irelia realiza una ráfaga de golpes rápidos, infligiendo daño a los enemigos en un área.');

-- Jhin
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(41, 41, 'Disparo Descontrolado', 'Jhin canaliza su poder para disparar una ráfaga de balas que inflige daño crítico a los enemigos alcanzados.');

-- Kalista
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(42, 42, 'Vínculo Rendidor', 'Kalista envía una lanza a su aliado, permitiéndole teleportarse hacia la ubicación de la lanza.');

-- Lulu
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(43, 43, 'Encantamiento Salvaje', 'Lulu mejora a un aliado, otorgándole velocidad de movimiento y aumentando su tamaño y resistencia.');

-- Mordekaiser
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(44, 44, 'Reino de la Muerte', 'Mordekaiser teletransporta a su objetivo a un reino unidireccional, donde se enfrentan en un duelo. Si Mordekaiser gana, obtiene el alma de su enemigo.');

-- Nami
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(45, 45, 'Maremoto', 'Nami invoca un maremoto que inflige daño y lanza a los enemigos cercanos al aire.');

-- Olaf
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(46, 46, 'Ira del Berserker', 'Olaf aumenta su velocidad de ataque y robo de vida, volviéndose inmune al control de masas.');

-- Poppy
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(47, 47, 'Embajadora del Martillo', 'Poppy carga su martillo y realiza un golpe potenciado que inflige daño y lanza a los enemigos.');

-- Qiyana
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(48, 48, 'Asalto Supreme', 'Qiyana canaliza el poder de la naturaleza para mejorar su siguiente habilidad, infligiendo daño adicional.');

-- Ryze
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(49, 49, 'Desesperación', 'Ryze canaliza su poder rúnico, mejorando sus habilidades y aumentando su velocidad de movimiento.');

-- Sejuani
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(50, 50, 'Cerdo de la Furia Glacial', 'Sejuani invoca a su cerdo Bristle, aumentando su velocidad de movimiento y ralentizando a los enemigos alcanzados.');

-- Shyvana
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(51, 51, 'Asalto Ardiente', 'Shyvana se transforma en un dragón, infligiendo daño a los enemigos cercanos y aumentando su resistencia.');

-- Swain
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(52, 52, 'Asedio Demoníaco', 'Swain invoca una tormenta de cuervos que inflige daño y extrae almas de los enemigos alcanzados.');

-- Tahm Kench
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(53, 53, 'Devorar', 'Tahm Kench engulle a un aliado, transportándolo hacia una ubicación específica y otorgándole escudo.');

-- Udyr
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(54, 54, 'Forma de Fénix', 'Udyr desata una explosión de fuego alrededor de sí mismo, infligiendo daño mágico a los enemigos cercanos.');

-- Varus
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(55, 55, 'Flecha de Castigo', 'Varus dispara una flecha perforadora que inflige daño a todos los enemigos en línea recta.');

-- Wukong
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(56, 56, 'Ciclón', 'Wukong gira su bastón, lanzando a los enemigos al aire y infligiendo daño en un área.');

-- Xayah
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(57, 57, 'Tormenta de Cuchillas', 'Xayah lanza un enjambre de plumas afiladas en un área, infligiendo daño a los enemigos alcanzados.');

-- Yorick
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(58, 58, 'Maldición de la Isla de las Sombras', 'Yorick invoca a la Dama de la Isla, que convoca esbirros y ataca a los enemigos cercanos.');

-- Zilean
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(59, 59, 'Cronoescalada', 'Zilean mejora el tiempo de un aliado, otorgándole velocidad de movimiento y reduciendo el enfriamiento de sus habilidades.');

-- Zoe
INSERT INTO HABILIDADES (id, id_personaje, hab_definitiva, descripcion) VALUES
(60, 60, 'Deslumbramiento Estelar', 'Zoe dispara una estrella que explota al impactar, infligiendo daño mágico y dejando a los enemigos dormidos temporalmente.');

INSERT INTO SERVIDORES (id, nombre_servidor, direccion_ip, descripcion) VALUES
(1, 'NA Server', 'na.leagueoflegends.com', 'North America server '),
(2, 'EUW Server', 'euw.leagueoflegends.com', 'Europe West server '),
(3, 'KR Server', 'kr.leagueoflegends.com', 'Korea server '),
(4, 'BR Server', 'br.leagueoflegends.com', 'Brazil server '),
(5, 'LAN Server', 'lan.leagueoflegends.com', 'Latin America North server ');

-- Users for NA Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(1, 'Summoner1', 1, 30),
(2, 'Player123', 1, 25),
(3, 'GamerGirl', 1, 28),
(4, 'ProPlayer', 1, 35),
(5, 'CasualGamer', 1, 18);
-- ... Continue adding more users for NA Server

-- Users for EUW Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(6, 'EuroGamer', 2, 32),
(7, 'LeagueMaster', 2, 40),
(8, 'SwiftStriker', 2, 22),
(9, 'VictoriousOne', 2, 37),
(10, 'CasualEUW', 2, 15);
-- ... Continue adding more users for EUW Server

-- Users for KR Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(11, 'KoreanChallenger', 3, 50),
(12, 'StarGazer', 3, 28),
(13, 'FlashMaster', 3, 42),
(14, 'KPopGamer', 3, 36),
(15, 'CasualKR', 3, 20);
-- ... Continue adding more users for KR Server

-- Users for BR Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(16, 'BrasilGamer', 4, 27),
(17, 'SambaStriker', 4, 33),
(18, 'CarnavalChampion', 4, 45),
(19, 'JungleKingBR', 4, 31),
(20, 'CasualBR', 4, 23);
-- ... Continue adding more users for BR Server

-- Users for LAN Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(21, 'LatinoGamer', 5, 29),
(22, 'SalsaMaster', 5, 38),
(23, 'FiestaChampion', 5, 44),
(24, 'LANLegend', 5, 26),
(25, 'CasualLAN', 5, 19);

-- Users for NA Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(26, 'EliteGamerNA', 1, 39),
(27, 'StrategicPlayer', 1, 32),
(28, 'RapidReaction', 1, 24),
(29, 'NAChampion', 1, 41),
(30, 'CasualNA2', 1, 17);

-- Users for EUW Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(31, 'SwiftSpectre', 2, 36),
(32, 'EUWChallenger', 2, 48),
(33, 'MysticMage', 2, 27),
(34, 'EUWPro', 2, 43),
(35, 'CasualEUW2', 2, 21);

-- Users for KR Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(36, 'KoreanStrategist', 3, 34),
(37, 'ShadowBladeKR', 3, 46),
(38, 'HighVelocity', 3, 29),
(39, 'KRDominator', 3, 38),
(40, 'CasualKR2', 3, 25);

-- Users for BR Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(41, 'BrazilianLegend', 4, 37),
(42, 'SambaSorcerer', 4, 42),
(43, 'BRWarrior', 4, 31),
(44, 'CarnavalQueen', 4, 49),
(45, 'CasualBR2', 4, 22);

-- Users for LAN Server
INSERT INTO USUARIOS (id, nombre, servidor, nivel) VALUES
(46, 'LatinoGamingMaster', 5, 33),
(47, 'FiestaFury', 5, 40),
(48, 'DanceDynasty', 5, 28),
(49, 'LANConqueror', 5, 45),
(50, 'CasualLAN2', 5, 18);
-- Match history for User 1
INSERT INTO HISTORIAL (id, id_usuario, id_personaje, kda, resultado, fecha, duracion, linea) VALUES
(1, 1, 1, 10, 'V', '2024-01-15', '00:25:30', 'Superior'),
(2, 1, 3, 5, 'D', '2024-01-17', '00:20:45', 'Inferior'),
(3, 1, 5, 8, 'V', '2024-01-20', '00:32:15', 'Central'),
(4, 1, 7, 12, 'V', '2024-01-22', '00:28:40', 'Jungla'),
(5, 1, 9, 6, 'D', '2024-01-25', '00:22:10', 'Apoyo');

-- Match history for User 2
INSERT INTO HISTORIAL (id, id_usuario, id_personaje, kda, resultado, fecha, duracion, linea) VALUES
(6, 2, 2, 7, 'V', '2024-01-16', '00:27:50', 'Superior'),
(7, 2, 4, 4, 'D', '2024-01-18', '00:23:05', 'Inferior'),
(8, 2, 6, 9, 'V', '2024-01-21', '00:30:20', 'Central'),
(9, 2, 8, 11, 'V', '2024-01-23', '00:26:45', 'Jungla'),
(10, 2, 10, 5, 'D', '2024-01-26', '00:24:30', 'Apoyo');
commit;
