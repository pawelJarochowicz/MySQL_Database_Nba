package nba.databa.jdbc.mysql;

import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseNba {
    public static void main(String[] args)throws SQLException {
        DtabaseCon datacon=new DtabaseCon();



        Statement statement = datacon.getConn().createStatement();
        statement.executeUpdate("CREATE DATABASE if not exists nba");
        statement.executeUpdate("USE nba");
        statement.executeUpdate("CREATE TABLE if not exists team(team_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(60) not null,city VARCHAR(60) not null, state varchar(30) not null, short_name varchar(3) not null);");
        statement.executeUpdate("CREATE TABLE if not exists coach(coach_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, first_name varchar(25) not null, last_name varchar(25) not null, team_id int, age int, foreign key(team_id) references team(team_id));");
        statement.executeUpdate("CREATE TABLE if not exists player(player_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, first_name varchar(25) not null, last_name varchar(25) not null,position varchar(2) not null, age int not null,team_id int, foreign key(team_id) references team(team_id));");
        statement.executeUpdate("CREATE TABLE if not exists team_stats(team_stats_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, off_points int not null, def_points int not null, off_rating int not null, def_rating int not null, champ_rating int not null, organisation int not null, team_id int, foreign key(team_id) references team(team_id));");
        statement.executeUpdate("CREATE TABLE if not exists coach_stats(coach_stats_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, experience int not null, wins_rat int not null, offensive int not null, defensive int not null,champs_rat int not null, coach_id int, foreign key(coach_id) references coach(coach_id));");
        statement.executeUpdate("CREATE TABLE if not exists player_stats(player_stats_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, points int not null, rebounds int not null, assists int not null, experience int not null, off_rat int not null, def_rat int not null, 3points int not null, clutch int not null, goat int not null, player_id int, foreign key(player_id) references player(player_id));");
        statement.executeUpdate("INSERT INTO team(team_id,name,city,state,short_name) VALUES(null,'Boston Celtics', 'Boston','Massachusetts','BOS'),(null,'Cleveland Cavaliers','Cleveland','Ohio','CLE'),(null,'Dallas Mavericks','Dallas','Texas','DAL'),(null,'Denver Nuggets','Denver','Colorado','DEN'),(null,'Golden State Warriors','Oakland','California','GSW'),(null,'Los Angeles Lakers','Los Angeles','California','LAL'),(null,'Philadelphia 76ers','Philadelphia','Pennsylvania','PHI'),(null,'Phoenix Suns','Phoenix','Arizona','PHX'),(null,'Toronto Raptors','Toronto','Ontario','TOR'),(null,'Utah Jazz','Salt Lake City','Utah','UTH');");
        statement.executeUpdate("INSERT INTO coach(coach_id,first_name,last_name,team_id,age) VALUES(null,'Brad','Stevens','1','41'),(null,'Tyronn','Lue','2','41'),(null,'Rick','Carlisle','3','59'),(null,'Mike','Malone','4','47'),(null,'Steve','Kerr','5','52'),(null,'Luke','Walton','6','38'),(null,'Brett','Brown','7','57'),(null,'Igor','Kokoskov','8','46'),(null,'Nick','Nurse','9','51'),(null,'Quin','Snyder','10','51');");
        statement.executeUpdate("load data infile \"C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\coach_stats.txt\"\ninto table coach_stats;");
        statement.executeUpdate("load data infile \"C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\team_stats.txt\"\ninto table team_stats;");
        statement.executeUpdate("load data infile \"C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\player.txt\"\ninto table player FIELDS TERMINATED BY ',';");








    }
}
