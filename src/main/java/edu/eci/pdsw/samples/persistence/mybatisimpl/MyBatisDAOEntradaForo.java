/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.persistence.mybatisimpl;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.entities.EntradaForo;
import edu.eci.pdsw.samples.entities.Usuario;
import edu.eci.pdsw.samples.persistence.DaoEntradaForo;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.EntradaForoMapper;
import java.util.List;
import java.util.Set;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author hcadavid
 */
public class MyBatisDAOEntradaForo implements DaoEntradaForo{

    private SqlSession currentSession=null;

    public MyBatisDAOEntradaForo(SqlSession session) {
        this.currentSession=session;
    }
        
    @Override
    public EntradaForo load(int id) throws PersistenceException {
        EntradaForoMapper e= currentSession.getMapper(EntradaForoMapper.class);
        EntradaForo ef= e.getEntradaForo(id);
        currentSession.commit();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return ef;
    }
    

    @Override
    public List<EntradaForo> loadAll() throws PersistenceException {
        EntradaForoMapper e= currentSession.getMapper(EntradaForoMapper.class);
        List<EntradaForo> ef= e.getEntradasForo();
        currentSession.commit();
       return ef;

        

    }

    @Override
    public void save(EntradaForo e) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(EntradaForo e) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addToForo(int idForo, Comentario c) throws PersistenceException {
        EntradaForoMapper e= currentSession.getMapper(EntradaForoMapper.class);
        e.agregarComentarioAEntradaForo(idForo, c);
        currentSession.commit();
    }
    
}
