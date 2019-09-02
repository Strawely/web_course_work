package dao;

import data.Team;
import data.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WorkerDao {
    public void add(Worker worker){
        try( Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("insert into worker values (?, ?, ?, ?)");
            statement.setObject(1, worker.getId());
            statement.setString(2, worker.getFullName());
            statement.setDate(3, worker.getBirthDate());
            statement.setObject(4, worker.getTeamId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public List<Worker> getAll() {
        try ( Connection connection = ConnectionManager.getInstance().getConnection() ) {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from worker");
            List<Worker> list = new ArrayList<>();
            while ( resultSet.next() ) {
                Worker worker = new Worker();
                worker.setId(UUID.fromString(resultSet.getString("id")));
                worker.setFullName(resultSet.getString("full_name"));
                worker.setBirthDate(resultSet.getDate("birth_date"));
                worker.setTeamId(UUID.fromString(resultSet.getString("team_id")));
                list.add(worker);
            }
            return list;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void delete(Worker worker){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("delete from worker where id = ?");
            statement.setObject(1, worker.getId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public void update(Worker worker){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement  = connection.prepareStatement("update worker set full_name = ?, birth_date = ?, team_id = ? " +
                    "where id = ?");
            statement.setObject(4, worker.getId());
            statement.setString(1, worker.getFullName());
            statement.setDate(2, worker.getBirthDate());
            statement.setObject(3, worker.getTeamId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }
}
