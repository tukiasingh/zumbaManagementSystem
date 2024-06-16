package org.example.db;

import org.example.model.Participant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ParticipantDao {
    Participant participant = new Participant();
    DB db = DB.getDB();

    public int addParticipant(Participant participant) {
        int result = 0;
        try {
            String sql = "insert into Participant values(null, ?,?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, participant.getName());
            preparedStatement.setString(2, participant.getPhoneNumber());
            preparedStatement.setString(3, participant.getEmail());

            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public int updateParticipant(Participant participant) {
        int result = 0;
        try {
            String sql = "update Participant set name=?, phone = ?, email = ? where pid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, participant.getName());
            preparedStatement.setString(2, participant.getPhoneNumber());
            preparedStatement.setString(3, participant.getEmail());
            preparedStatement.setInt(4, participant.getPid());


            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }



    public ArrayList<Participant> getParticipants() {
        ArrayList<Participant> participants = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String sql = "select * from Participant";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            resultSet = db.executeQuery(preparedStatement);
            while (resultSet.next()) {
                Participant participant = new Participant();
                participant.setPid(resultSet.getInt(1));
                participant.setName(resultSet.getString(2));
                participant.setPhoneNumber(resultSet.getString(3));
                participant.setEmail(resultSet.getString(4));

                participants.add(participant);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return participants;

    }

    public int deleteParticipant(int pid) {
        int result = 0;
        try {

            String sql = "delete from Participant where pid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pid);

            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public String getParticipantNameByPid(int pid) {
        ResultSet resultSet = null;
        String name = null;
        try {
            String sql = "select name from Participant where pid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pid);
            resultSet = db.executeQuery(preparedStatement);
            if (resultSet.next()) {
                name = resultSet.getString("name");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Participant name for pid" +pid+" is: "+name);
        return name;

    }

    public int getParticipantPidByName(String name) {
        ResultSet resultSet = null;
        int pid = 0;
        try {
            System.out.println("We are trying to find pid for: "+name);
            String sql = "select pid from Participant where name = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = db.executeQuery(preparedStatement);
            if (resultSet.next()) {
                pid = resultSet.getInt("pid");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Participant pid for name" +name+" is: "+pid);
        return pid;

    }



    public Participant getParticipantByPid(int pid) {
        ResultSet resultSet = null;
        String name = null;
        try {
            String sql = "select * from Participant where pid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pid);
            resultSet = db.executeQuery(preparedStatement);
            if (resultSet.next()) {

                participant.setName(resultSet.getString("name"));
                participant.setPhoneNumber(resultSet.getString("phone"));
                participant.setEmail(resultSet.getString("email"));
                participant.setPid(pid);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return participant;

    }
}

