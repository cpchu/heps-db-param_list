/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.api;

import heps.db.param_list.entity.Attribute;
import heps.db.param_list.entity.Data;
import heps.db.param_list.entity.Manager;
import heps.db.param_list.entity.Parameter;
import heps.db.param_list.entity.Reference;
import heps.db.param_list.entity.Team;
import heps.db.param_list.entity.Unit;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author Paul
 */
public class DataAPI {

    @PersistenceUnit
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
    EntityManager em = emf.createEntityManager();

    @PersistenceContext

    public Data getDataFor(String sys, String team, String param_name, String attribute) {
        
       try {
        Data data = em.createQuery("SELECT d FROM Data d WHERE d.system.name=:system_id AND d.team.name=:team_id AND d.parameter.name=:parameter_id AND d.attribute.name=:attribute_id ",Data.class)
                     
                .setParameter("system_id", sys)
                .setParameter("team_id", team)
                .setParameter("parameter_id", param_name)
                .setParameter("attribute_id", attribute)
                      .getSingleResult();
       

        return data;
       } catch (NoResultException e1){
           System.out.println("没检索到data");
           Data data = null;
           return data;
       }
    }

    public void updateData(Data data, ParameterAPI p) {
        //em.getTransaction().begin();
        
        data.setValue(p.getData());
        data.setDatemodified(p.getDate());
        data.setComment(p.getDef());
        data.setStatus("");
        Attribute att = em.createQuery("SELECT a FROM Attribute a WHERE a.name =:name", Attribute.class).setParameter("name", p.getAtt()).getSingleResult();

        data.setAttribute(att);
        heps.db.param_list.entity.System sys = em.createQuery("SELECT s FROM jpa.entities.System s WHERE s.name = :name", heps.db.param_list.entity.System.class).setParameter("name", p.getSys()).getSingleResult();
        data.setSystem(sys);
        Team team = em.createQuery("SELECT t FROM Team t WHERE t.name = :name", Team.class).setParameter("name", p.getTeam()).getSingleResult();
        data.setTeam(team);
        //System.out.println("parameter name"+ p.getParam_name());
        Parameter param = em.createQuery("SELECT p FROM Parameter p WHERE p.name = :name", Parameter.class).setParameter("name", p.getParam_name()).getSingleResult();
        
        data.setParameter(param);

        em.persist(data);
        
        //em.getTransaction().commit();
        em.close();
        //emf.close();

    }

    public void saveNewParameter(ParameterAPI p) {
        //em.getTransaction().begin();
        Data data = new Data();
        data.setValue(p.getData());
        data.setDatemodified(p.getDate());
        data.setComment(p.getDef());
        data.setStatus("");

        try {
            Attribute att = em.createQuery("SELECT a FROM Attribute a WHERE a.name =:name", Attribute.class).setParameter("name", p.getAtt()).getSingleResult();

            data.setAttribute(att);
        } catch (NoResultException e1) {
            Attribute att = new Attribute();
            att.setName(p.getAtt());
            data.setAttribute(att);
        }

        try {
            heps.db.param_list.entity.System sys = em.createQuery("SELECT s FROM jpa.entities.System s WHERE s.name = :name", heps.db.param_list.entity.System.class).setParameter("name", p.getSys()).getSingleResult();
            data.setSystem(sys);
        } catch (NoResultException e2) {
            heps.db.param_list.entity.System sys = new heps.db.param_list.entity.System();
            sys.setName(p.getSys());
            try {
                heps.db.param_list.entity.System parent_sys = em.createQuery("SELECT s FROM jpa.entities.System s WHERE s.name = :name", heps.db.param_list.entity.System.class).setParameter("name", p.getParent_sys()).getSingleResult();
                sys.setParentid(parent_sys);
            } catch (NoResultException e21) {
                heps.db.param_list.entity.System parent_sys = new heps.db.param_list.entity.System();
                parent_sys.setName(p.getParent_sys());
                sys.setParentid(parent_sys);
            }
            data.setSystem(sys);
        }

        try {
            Team team = em.createQuery("SELECT t FROM Team t WHERE t.name = :name", Team.class).setParameter("name", p.getTeam()).getSingleResult();
            data.setTeam(team);

        } catch (NoResultException e3) {
            Team team = new Team();
            team.setName(p.getTeam());
            try {
                Team parent_team = em.createQuery("SELECT t FROM Team t WHERE t.name =:name", Team.class).setParameter("name", p.getParent_team()).getSingleResult();
                team.setParentid(parent_team);

            } catch (NoResultException e31) {
                Team parent_team = new Team();
                parent_team.setName(p.getParent_team());
                team.setParentid(parent_team);
            }
            try {
                Manager manager = em.createQuery("SELECT m FROM Manager m WHERE m.name = :name", Manager.class).setParameter("name", p.getTeam_manager()).getSingleResult();
                team.setManagerid(manager);
            } catch (NoResultException e32) {
                Manager manager = new Manager();
                manager.setName(p.getTeam_manager());
                team.setManagerid(manager);
            }
            data.setTeam(team);
        }

        try {
            Parameter param = em.createQuery("SELECT p FROM Parameter p WHERE p.name = :name", Parameter.class).setParameter("name", p.getParam_name()).getSingleResult();
            //System.out.println("parameter name"+parameter.getName());
            data.setParameter(param);
        } catch (NoResultException e4) {
            // System.out.println("主键参数名查找不到，将重新创建");
            Parameter param = new Parameter();
            param.setName(p.getParam_name().replaceAll("\\s*", ""));
//            param.setDatemodified(p.getDate());
            param.setDefinition(p.getDef());
            try {
                Unit unit = em.createQuery("SELECT u FROM Unit u WHERE u.name = :name", Unit.class).setParameter("name", p.getUnit()).getSingleResult();
                param.setUnitid(unit);
                //y++;
                //System.out.println("重复Unit："+unit.getName()+"y:"+y);

            } catch (NoResultException e41) {
                // System.out.println("Unit:"+e1.getMessage());
                Unit unit = new Unit();
                unit.setName(p.getUnit());
                param.setUnitid(unit);
                //System.out.println("unit success!" + unit.getName() + unit.getId());
            }

            try {
                Reference ref = em.createQuery("SELECT r FROM Reference r WHERE r.title = :title", Reference.class).setParameter("title", p.getRef_title()).getSingleResult();
                param.setReferenceid(ref);
                //z++;
            } catch (NoResultException e42) {
                Reference ref = new Reference();
                ref.setTitle(p.getRef_title());
                ref.setAuthor(p.getRef_author());
                ref.setPublication(p.getRef_publication());
                ref.setUrl(p.getRef_url());
                ref.setKeywords(p.getKeyword());
                param.setReferenceid(ref);
            }
            data.setParameter(param);

        }

        em.persist(data);
        
        //em.getTransaction().commit();
        em.close();
        //emf.close();
    }
}
