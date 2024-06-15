package org.example.db;

import org.example.model.Batch;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;

public class BatchDao {

    Batch batch = new Batch();
    DB db = DB.getDB();


    public int addBatch(Batch batch) {
        int result = 0;
        try {
            String sql = "insert into Batch values(null, ?,?)";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, batch.getTitle());
            preparedStatement.setString(2, batch.getStartTime());

            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public int updateBatch(Batch batch) {
        int result = 0;
        try {
            String sql = "update Batch set title=?, startTime = ? where bid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, batch.getTitle());
            preparedStatement.setString(2, batch.getStartTime());
            preparedStatement.setInt(3, batch.getBid());


            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }


    public int getBatchBidByTitle(String title) {
        ResultSet resultSet = null;
        int bid = 0;
        try {
            System.out.println("We are trying to find bid for: "+title);
            String sql = "select bid from Batch where title = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            resultSet = db.executeQuery(preparedStatement);
            if (resultSet.next()) {
                bid = resultSet.getInt("bid");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Batch bid for " +title+" is: "+bid);
        return bid;

    }



    public String getBatchTitleByBid(int bid) {
        ResultSet resultSet = null;
        String batchTitle = null;
        try {
            String sql = "select title from Batch where bid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, bid);
            resultSet = db.executeQuery(preparedStatement);
            if (resultSet.next()) {
                batchTitle = resultSet.getString("title");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Batch name for bid" +bid+" is: "+batchTitle);
        return batchTitle;

    }

    public String getBatchTimeByBid(int bid) throws ParseException {
        ResultSet resultSet = null;
        String batchTime = null;
        try {
            String sql = "select startTime from Batch where bid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, bid);
            resultSet = db.executeQuery(preparedStatement);
            if (resultSet.next()) {
                batchTime = resultSet.getString("startTime");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Batch startTime" +bid+" is: "+batchTime);
        return batchTime;

    }

    public ArrayList<Batch> getBatches() {
        ArrayList<Batch> batches = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            String sql = "select * from Batch";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
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

    public Batch getBatchByBid(int bid) {
        ResultSet resultSet = null;
//        Batch batch = new Batch();
        try {
            String sql = "select * from Batch where bid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, bid);
            resultSet = db.executeQuery(preparedStatement);
            if (resultSet.next()) {
                batch.setTitle(resultSet.getString("title"));
                batch.setStartTime(resultSet.getString("startTime"));
                batch.setBid(bid);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return batch;

    }

    public int deleteBatch(int bid) {
        int result = 0;
        try {

            String sql = "delete from Batch where bid = ?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, bid);

            result = db.executeUpdate(preparedStatement);


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("[DAO]: Result value after trying to delete batch with bid: "+bid+" is: "+result);
        return result;

    }

}
