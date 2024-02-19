package Service;
import Entites.Concours;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Utils.DataSource;
public class ServiceConcours implements IService<Concours>{

    private Connection con=DataSource.getInstance().getCon();

    private Statement ste;

    public ServiceConcours()
    {
        try {
            ste= con.createStatement();
        }catch (SQLException e)
        {
            System.out.println(e);
        }


    }
    @Override
    public void ajouter(Concours concours) throws SQLException {

        String req="INSERT INTO `concours` ( `date`, `type`, `prix`, `Lien`) VALUES ( '"+concours.getDate()+"', '"+concours.getType()+"', '"+concours.getPrix()+"', '"+concours.getLien()+"');";
        ste.executeUpdate(req);
    }
    public void ajouterPST(Concours concours) throws SQLException {

        String req="INSERT INTO `concours` ( `date`, `type`, `prix`, `Lien`) VALUES ( ?,?,?,?);";
        PreparedStatement pre=con.prepareStatement(req);

        pre.setString(1,concours.getDate());
        pre.setString(2,concours.getType());
        pre.setInt(3,concours.getPrix());
        pre.setString(3,concours.getLien());

        pre.executeUpdate();
    }

    @Override
    public boolean delete(Concours concours) throws SQLException {
        String query = "DELETE FROM `concours` WHERE reference=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, concours.getReference());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public void update(Concours concours) throws SQLException {
        String query = "UPDATE `concours` SET `date`=?,`type`=?,`prix`=?,`lien`=? WHERE reference=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, concours.getDate());
            preparedStatement.setString(2, concours.getType());
            preparedStatement.setInt(3, concours.getPrix());
            preparedStatement.setString(4, concours.getLien());


            int rows = preparedStatement.executeUpdate();
            if(rows > 0) {
                System.out.println("updated");
            } else {
                System.out.println("not updated");
            }

        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public Concours findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Concours> readAll() throws SQLException {

        List<Concours> list=new ArrayList<>();
        ResultSet res=ste.executeQuery("select * from concours");
        while (res.next()) {

            int reference = res.getInt(1);
            String date = res.getString("date");
            String lien = res.getString("lien");
            String type = res.getString("type");
            int prix = res.getInt("prix");
            Concours p1=new Concours(reference,prix,date,type,lien);
            list.add(p1);
        }

        return list;
    }
}

