
package com.emergentes.dao;
import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.conexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class avisoDAOompl extends conexionBD implements avisoDAO{

    @Override
    public void insert(Aviso aviso) throws Exception {
        try{
      this.conectar();
      PreparedStatement ps = this.conn.prepareStatement("INSERT into avisos(Titulo, contenido)(?, ?) ");
    ps.setString(1, aviso.getTitulo);
    ps.setString(2, aviso.getContenido);
    ps.executeUpdate();
    }catch(Exception e){
        throw e;
        }finally {
            this.desconectar();
        }
    }
    @Override
    public void update(Aviso aviso) throws Exception {
        try{
        this.conectar();
        PreparedStatement ps= this.conn.prepareStatement("UPDATE avisos set titulo=?, contenido =? WHERE id=?");
    ps.setString(1, aviso.getTitulo());
    ps.setString(2, aviso.getcontenido());
    ps.setInt(3, aviso.getid);
    ps.executeUpdate();
        }catch(Exception e){
        throw e;
        }finally {
            this.desconectar();
        }
    }
    @Override
    public void delete(int id) throws Exception {
try{
        this.conectar();
        PreparedStatement ps= this.conn.prepareStatement("DELETE FROM avisosdo WHERE id=?");
    ps.setInt(1, id);
    ps.executeUpdate();
        }catch(Exception e){
        throw e;
        }finally {
            this.desconectar();
        }
    }

    @Override
    public Aviso getById(int id) throws Exception {
    
        Aviso avi = new Aviso();
        try{
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM  avisos WHERE id=?  ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                avi.setid(rs.getInt("id"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
            }
        }catch(Exception e){
        throw e;
        }finally {
            this.desconectar();
        }
        return avi;
    }

    @Override
    public List<Aviso> getAll() throws Exception {
List <Aviso> lista = null;
try{
    this.conectar();
    PreparedStatement ps = this.conn.prepareStatement("SELECT *  FROM avisos");
    ResultSet rs = ps.executeQuery();
    lista = new ArrayList<Aviso>();
    while (rs.next()) {
        Aviso avi = new Aviso();
        avi.setid(rs.getInt("id"));
        avi.settitulo(rs.getInt("titulo"));
        avi.setcontenido(rs.getString("contenido"));
        lista.add(avi);
    }
    rs.close();
    ps.close();
    
}
catch(Exception e){
        throw e;
        }finally {
            this.desconectar();
        }
        return lista;
}
    }