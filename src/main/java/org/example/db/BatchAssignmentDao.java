package org.example.db;

import org.example.model.Batch;
import org.example.model.Participant;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BatchAssignmentDao {

    Participant participant = new Participant();
    Batch batch = new Batch();
    DB db = DB.getDB();


    public ArrayList<Batch> getBatchesForParticipant(int pid) {
        ArrayList<Batch> batches = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String sql = "select * from Batch JOIN BatchAssignment ON Batch.bid=BatchAssignment.bid  where BatchAssignment.pid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pid);
            resultSet = db.executeQuery(preparedStatement);
            while (resultSet.next()) {
                Batch batch = new Batch();
                batch.setBid(resultSet.getInt(1));
                batch.setTitle(resultSet.getString(2));
                batch.setStartTime(resultSet.getString(3));

                batches.add(batch);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batches;

    }



    public ArrayList<Batch> findBatchesForParticipant(int pid) {
        ArrayList<Batch> batches = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String sql = "select distinct Batch.bid , title, startTime from Batch JOIN BatchAssignment ON Batch.bid=BatchAssignment.bid  " +
                    "where BatchAssignment.pid <> ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pid);
            resultSet = db.executeQuery(preparedStatement);
            while (resultSet.next()) {
                Batch batch = new Batch();
                batch.setBid(resultSet.getInt(1));
                batch.setTitle(resultSet.getString(2));
                batch.setStartTime(resultSet.getString(3));

                batches.add(batch);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batches;

    }

    public ArrayList<Participant> getParticipantsForBatch(int bid) {
        ArrayList<Participant> participants = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String sql = "select * from Participant JOIN BatchAssignment ON Participant.pid=BatchAssignment.pid  " +
                    "where BatchAssignment.bid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, bid);
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

    public int registerToBatch(int pid, int bid) {
        int result = 0;
        try {
            String sql = "insert into BatchAssignment values(?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pid);
            preparedStatement.setInt(2, bid);

            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public int unregister (int pid, int bid) {
        int result = 0;

        try {

            String sql = "delete from BatchAssignment where pid = ? and bid= ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pid);
            preparedStatement.setInt(2, bid);

            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[DAO]:You are now unregistered for pid: "+pid+" bid: "+bid);
        return result;

    }

    public int register (int pid, int bid) {
        int result = 0;

        try {

            String sql = "insert into BatchAssignment values(?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, pid);
            preparedStatement.setInt(2, bid);

            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[DAO]:You are now registered for pid: "+pid+" bid: "+bid);
        return result;

    }
}
