package dao;

import data.Job;
import data.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JobDao {
    public void add(Job job){
        try( Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("insert into job values (?, ?, ?, ?, ?)");
            statement.setObject(1, job.getId());
            statement.setDate(2, job.getStartDate());
            statement.setDate(3, job.getFinishDate());
            statement.setObject(4, job.getFieldId());
            statement.setObject(5, job.getTeamId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public List<Job> getAll() {
        try ( Connection connection = ConnectionManager.getInstance().getConnection() ) {
            ResultSet resultSet = connection.createStatement().executeQuery("select * from job");
            List<Job> list = new ArrayList<>();
            while ( resultSet.next() ) {
                Job job = new Job();
                job.setId(UUID.fromString(resultSet.getString("id")));
                job.setStartDate(resultSet.getDate("start_date"));
                job.setFinishDate(resultSet.getDate("finish_date"));
                job.setTeamId(UUID.fromString(resultSet.getString("field_id")));
                job.setTeamId(UUID.fromString(resultSet.getString("team_id")));
                list.add(job);
            }
            return list;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void delete(Job job){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement = connection.prepareStatement("delete from job where id = ?");
            statement.setObject(1, job.getId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }

    public void update(Job job){
        try (Connection connection = ConnectionManager.getInstance().getConnection()){
            PreparedStatement statement  = connection.prepareStatement("update job set start_date = ?, finish_date = ?," +
                    "field_id = ?, team_id = ? where id = ?");
            statement.setDate(1, job.getStartDate());
            statement.setDate(2, job.getFinishDate());
            statement.setObject(3, job.getFieldId());
            statement.setObject(4, job.getTeamId());
            statement.setObject(5, job.getId());
            statement.execute();
        }
        catch ( Exception ex ){
            ex.printStackTrace();
        }
    }
}
