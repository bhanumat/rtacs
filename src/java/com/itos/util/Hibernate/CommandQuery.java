/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itos.util.Hibernate;

import com.itos.util.DateUtil;
import com.itos.util.jqGrid.Condition;
import com.itos.util.jqGrid.JqGridRequest;
import com.itos.util.jqGrid.Paging;
import com.itos.util.jqGrid.Search;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ITOS
 */
public class CommandQuery {

    private static final Locale ENG_LOCALE = new Locale("en", "EN");
    private static final SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy", ENG_LOCALE);
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", ENG_LOCALE);
    
    /*
     * Command HQL query count rows. LoadDetailByObject
     * Set paging start and stop.
     */
    public static Query CreateQuery(SessionFactory sessionFactory, String objectTable, List<WhereField> listWhereField, int startIndex, int endIndex) {
        StringBuilder hql = new StringBuilder();
        int iCount = 0;

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);

        if (!listWhereField.isEmpty()) {
            hql.append(" ");
            hql.append(CommandConstant.QueryWhere);
            hql.append(" ");
            for (WhereField whereField : listWhereField) {
                if (0 != iCount) {
                    hql.append(" ");
                    hql.append(whereField.getSearchLogic());
                    hql.append(" ");
                }
                if (CommandConstant.QueryEqual.equalsIgnoreCase(whereField.getSearchOper())) {
                    hql.append(whereField.getSearchField()).append(" = :").append(whereField.getSearchField());
                } else {
                    hql.append(whereField.getSearchField()).append(" LIKE :").append(whereField.getSearchField());
                }
                iCount++;
            }
        }

        Query query;
        try {
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());
            query.setFirstResult(startIndex);
            query.setMaxResults(endIndex);
            if (!listWhereField.isEmpty()) {
                for (WhereField whereField : listWhereField) {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(whereField.getSearchOper())) {
                        if (CommandConstant.DataTypeChar.equalsIgnoreCase(whereField.getSearchDataType())) {
                            if (whereField.getSearchValue().toString().length() == 1) {
                                query.setCharacter(whereField.getSearchField(), whereField.getSearchValue().toString().charAt(0));
                            } else {
                                query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                            }
                        } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(whereField.getSearchDataType())) {
                            query.setInteger(whereField.getSearchField(), null == whereField.getSearchValue() ? 0 : Integer.valueOf(whereField.getSearchValue().toString()));
                        } else {
                            query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                        }
                    } else {
                        if (CommandConstant.DataTypeChar.equalsIgnoreCase(whereField.getSearchDataType())) {
                            if (whereField.getSearchValue().toString().length() == 1) {
                                if (whereField.getSearchValue().toString().length() == 1) {
                                    query.setCharacter(whereField.getSearchField(), whereField.getSearchValue().toString().charAt(0));
                                } else {
                                    query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                                }
                            } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(whereField.getSearchDataType())) {
                                query.setInteger(whereField.getSearchField(), null == whereField.getSearchValue() ? 0 : Integer.valueOf(whereField.getSearchValue().toString()));
                            } else {
                                query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                            }
                        } else {
                            query.setParameter(whereField.getSearchField(), "%" + whereField.getSearchValue() + "%");
                        }
                    }
                }
            }
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return query;
    }

    /*
     * Command HQL query count rows.
     */
    public static Query CreateQuery(SessionFactory sessionFactory, String objectTable) {
        StringBuilder hql = new StringBuilder();
        int iCount = 0;

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);

        Query query;
        try {
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return query;
    }

    /*
     * Command HQL query count rows. ListInJSON
     */
    public static Query CreateQuery(SessionFactory sessionFactory, String objectTable, List<WhereField> listWhereField) {
        StringBuilder hql = new StringBuilder();
        int iCount = 0;

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);
        if (!listWhereField.isEmpty()) {
            hql.append(" ");
            hql.append(CommandConstant.QueryWhere);
            hql.append(" ");
            for (WhereField whereField : listWhereField) {
                if (0 != iCount) {
                    hql.append(" ");
                    hql.append(whereField.getSearchLogic());
                    hql.append(" ");
                }
                if (CommandConstant.DataTypeDate.equalsIgnoreCase(whereField.getSearchDataType())) {
                    String[] tempDate = whereField.getSearchValue().toString().split(",");
                    String beginDate = tempDate[0];
                    String endDate = tempDate[1];
                    hql.append(whereField.getSearchField());
                    hql.append(" between ");
                    hql.append(" \'").append(beginDate).append("\' ");
                    hql.append(" and \'").append(endDate).append("\' ");
                    //hql.append(" between :beginDate and :endDate "); 
                } else {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(whereField.getSearchOper())) {
                        hql.append(whereField.getSearchField()).append(" = :").append(whereField.getSearchField());
                    } else {
                        hql.append(whereField.getSearchField()).append(" LIKE :").append(whereField.getSearchField());
                    }
                }
                iCount++;
            }
        }

        Query query;
        try {
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());
            if (!listWhereField.isEmpty()) {
                for (WhereField whereField : listWhereField) {
                    if (CommandConstant.QueryBetween.equalsIgnoreCase(whereField.getSearchOper())
                            && CommandConstant.DataTypeDate.equalsIgnoreCase(whereField.getSearchDataType())) {
//                        String[] tempDate = whereField.getSearchValue().toString().split(",");
//                        String beginDate = tempDate[0];
//                        String endDate = tempDate[1];
//                        query.setParameter("beginDate", beginDate);
//                        query.setParameter("endDate", endDate);
                        System.out.println("in search date ------------------------");
                    } else {
                        if (CommandConstant.QueryEqual.equalsIgnoreCase(whereField.getSearchOper())) {
                            if (CommandConstant.DataTypeChar.equalsIgnoreCase(whereField.getSearchDataType())) {
                                if (whereField.getSearchValue().toString().length() == 1) {
                                    query.setCharacter(whereField.getSearchField(), whereField.getSearchValue().toString().charAt(0));
                                } else {
                                    query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                                }
                            } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(whereField.getSearchDataType())) {
                                query.setInteger(whereField.getSearchField(), null == whereField.getSearchValue() ? 0 : Integer.valueOf(whereField.getSearchValue().toString()));
                            } else {
                                query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                            }
                        } else {
                            if (CommandConstant.DataTypeChar.equalsIgnoreCase(whereField.getSearchDataType())) {
                                if (whereField.getSearchValue().toString().length() == 1) {
                                    query.setCharacter(whereField.getSearchField(), whereField.getSearchValue().toString().charAt(0));
                                } else {
                                    query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                                }
                            } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(whereField.getSearchDataType())) {
                                query.setInteger(whereField.getSearchField(), null == whereField.getSearchValue() ? 0 : Integer.valueOf(whereField.getSearchValue().toString()));
                            } else {
                                query.setParameter(whereField.getSearchField(), "%" + whereField.getSearchValue() + "%");
                            }
                        }
                    }
                }
            }
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return query;
    }

    /*
     * Command HQL query Data. Jqgrid
     * Set paging start and stop.
     */
    public static Query CreateQuery(SessionFactory sessionFactory, JqGridRequest req, String objectTable, Paging paging) {
        boolean isSearch = false;
        StringBuilder hql = new StringBuilder();
        String whereQuery = "";
        Search search;

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);

        if (req.isSearch()) {
            whereQuery = WhereQuery(req, true, "");
            if (!whereQuery.isEmpty()) {
                isSearch = true;
            }
            hql.append(whereQuery);
        }
        hql.append(" ");
        hql.append(CommandConstant.OrderBy);
        hql.append(" ");
        hql.append(req.getSidx());
        hql.append(" ");
        hql.append(req.getSord());

        Query query;
        try {
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());
            query.setFirstResult(paging.getStartIndex());
            query.setMaxResults(paging.getEndIndex());
            /*
             if (isSearch) {
             if (CommandConstant.QueryEqual.equalsIgnoreCase(req.getSearchOper())) {
             query.setParameter(req.getSearchField(), req.getSearchString());
             } else {
             query.setParameter(req.getSearchField(), "%" + req.getSearchString() + "%");
             }
             }*/
            if (isSearch) {
                if (null != req.getSearchField()
                        && null != req.getSearchOper()
                        && null != req.getSearchString()
                        && !req.getSearchField().isEmpty()
                        && !req.getSearchOper().isEmpty()
                        && !req.getSearchString().isEmpty()) {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(req.getSearchOper())) {
                        query.setParameter(req.getSearchField(), req.getSearchString());
                    } else {
                        query.setParameter(req.getSearchField(), "%" + req.getSearchString() + "%");
                    }
                } else if (null != req.getSearchCommand() && !req.getSearchCommand().isEmpty()) {
                    search = new Search();
                    search = Search.JSONDeserializer(req.getSearchCommand());
                    for (Condition condition : search.getConditions()) {
                        if (null == condition.getJoinType() || condition.getJoinType().isEmpty()) {
                            if (CommandConstant.QueryBetween.equalsIgnoreCase(condition.getOp())) {
                                
                            }else{
                                if (CommandConstant.QueryEqual.equalsIgnoreCase(condition.getOp())) {
                                    if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                                        query.setParameter(condition.getField(), condition.getData());
                                    } else if (CommandConstant.DataTypeChar.equalsIgnoreCase(condition.getDataType())) {
                                        if (condition.getData().length() == 1) {
                                            query.setCharacter(condition.getField(), condition.getData().charAt(0));
                                        } else {
                                            query.setParameter(condition.getField(), condition.getData());
                                        }
                                    } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                                        query.setInteger(condition.getField(), null == condition.getData() ? 0 : Integer.valueOf(condition.getData().toString()));
                                    } else {
                                        query.setParameter(condition.getField(), condition.getData());
                                    }
                                } else {
                                    if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                                        query.setParameter(condition.getField(), "%" + condition.getData() + "%");
                                    } else if (CommandConstant.DataTypeChar.equalsIgnoreCase(condition.getDataType())) {
                                        if (condition.getData().length() == 1) {
                                            query.setCharacter(condition.getField(), condition.getData().charAt(0));
                                        } else {
                                            query.setParameter(condition.getField(), condition.getData());
                                        }
                                    } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                                        query.setInteger(condition.getField(), null == condition.getData() ? 0 : Integer.valueOf(condition.getData().toString()));
                                    } else {
                                        query.setParameter(condition.getField(), "%" + condition.getData() + "%");
                                    }
                                }
                            }
                        } else {
                            //query.
                        }
                    }
                }
            }
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return query;
    }

    /*
     * Command HQL query Data. Jqgrid
     * Set paging start and stop.
     */
    public static Query CreateQuery(SessionFactory sessionFactory, List<WhereField> listWhereField, String commandQuery, JqGridRequest req, String objectTable, Paging paging) {
        boolean isSearch = false;
        StringBuilder hql = new StringBuilder();
        String whereQuery = "";
        Search search;
        int iCount = 0;
        Boolean whereQueryControl = false;

        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);

        if (!listWhereField.isEmpty()) {
            hql.append(" ");
            hql.append(CommandConstant.QueryWhere);
            hql.append(" ");
            for (WhereField whereField : listWhereField) {
                if (0 != iCount) {
                    hql.append(" ");
                    hql.append(whereField.getSearchLogic());
                    hql.append(" ");
                }
                if (CommandConstant.QueryEqual.equalsIgnoreCase(whereField.getSearchOper())) {
                    hql.append(whereField.getSearchField()).append(" = :").append(whereField.getSearchField());
                } else {
                    hql.append(whereField.getSearchField()).append(" LIKE :").append(whereField.getSearchField());
                }
                iCount++;
            }
        }else{
            whereQueryControl = true;
        }

        if (req.isSearch()) {
            whereQuery = WhereQuery(req, whereQueryControl, commandQuery);
            if (!whereQuery.isEmpty()) {
                isSearch = true;
            }
            hql.append(whereQuery);
        }
        hql.append(" ");
        hql.append(CommandConstant.OrderBy);
        hql.append(" ");
        hql.append(req.getSidx());
        hql.append(" ");
        hql.append(req.getSord());

        Query query;
        try {
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());
            query.setFirstResult(paging.getStartIndex());
            query.setMaxResults(paging.getEndIndex());
            /*
             if (isSearch) {
             if (CommandConstant.QueryEqual.equalsIgnoreCase(req.getSearchOper())) {
             query.setParameter(req.getSearchField(), req.getSearchString());
             } else {
             query.setParameter(req.getSearchField(), "%" + req.getSearchString() + "%");
             }
             }*/
            if (!listWhereField.isEmpty()) {
                for (WhereField whereField : listWhereField) {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(whereField.getSearchOper())) {
                        if (CommandConstant.DataTypeChar.equalsIgnoreCase(whereField.getSearchDataType())) {
                            if (whereField.getSearchValue().toString().length() == 1) {
                                query.setCharacter(whereField.getSearchField(), whereField.getSearchValue().toString().charAt(0));
                            } else {
                                query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                            }
                        } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(whereField.getSearchDataType())) {
                            query.setInteger(whereField.getSearchField(), null == whereField.getSearchValue() ? 0 : Integer.valueOf(whereField.getSearchValue().toString()));
                        } else {
                            query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                        }
                    } else {
                        if (CommandConstant.DataTypeChar.equalsIgnoreCase(whereField.getSearchDataType())) {
                            if (whereField.getSearchValue().toString().length() == 1) {
                                if (whereField.getSearchValue().toString().length() == 1) {
                                    query.setCharacter(whereField.getSearchField(), whereField.getSearchValue().toString().charAt(0));
                                } else {
                                    query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                                }
                            } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(whereField.getSearchDataType())) {
                                query.setInteger(whereField.getSearchField(), null == whereField.getSearchValue() ? 0 : Integer.valueOf(whereField.getSearchValue().toString()));
                            } else {
                                query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                            }
                        } else {
                            query.setParameter(whereField.getSearchField(), "%" + whereField.getSearchValue() + "%");
                        }
                    }
                }
            }

            if (isSearch) {
                if (null != req.getSearchField()
                        && null != req.getSearchOper()
                        && null != req.getSearchString()
                        && !req.getSearchField().isEmpty()
                        && !req.getSearchOper().isEmpty()
                        && !req.getSearchString().isEmpty()) {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(req.getSearchOper())) {
                        query.setParameter(req.getSearchField(), req.getSearchString());
                    } else {
                        query.setParameter(req.getSearchField(), "%" + req.getSearchString() + "%");
                    }
                } else if (null != req.getSearchCommand() && !req.getSearchCommand().isEmpty()) {
                    search = new Search();
                    search = Search.JSONDeserializer(req.getSearchCommand());
                    for (Condition condition : search.getConditions()) {
                        if (null == condition.getJoinType() || condition.getJoinType().isEmpty()) {
                            if (CommandConstant.QueryEqual.equalsIgnoreCase(condition.getOp())) {
                                if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                                    query.setParameter(condition.getField(), condition.getData());
                                } else if (CommandConstant.DataTypeChar.equalsIgnoreCase(condition.getDataType())) {
                                    if (condition.getData().length() == 1) {
                                        query.setCharacter(condition.getField(), condition.getData().charAt(0));
                                    } else {
                                        query.setParameter(condition.getField(), condition.getData());
                                    }
                                } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                                    query.setInteger(condition.getField(), null == condition.getData() ? 0 : Integer.valueOf(condition.getData().toString()));
                                } else {
                                    query.setParameter(condition.getField(), condition.getData());
                                }
                            } else {
                                if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                                    query.setParameter(condition.getField(), "%" + condition.getData() + "%");
                                } else if (CommandConstant.DataTypeChar.equalsIgnoreCase(condition.getDataType())) {
                                    if (condition.getData().length() == 1) {
                                        query.setCharacter(condition.getField(), condition.getData().charAt(0));
                                    } else {
                                        query.setParameter(condition.getField(), condition.getData());
                                    }
                                } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                                    query.setInteger(condition.getField(), null == condition.getData() ? 0 : Integer.valueOf(condition.getData().toString()));
                                } else {
                                    query.setParameter(condition.getField(), "%" + condition.getData() + "%");
                                }
                            }
                        } else {
                            //query.
                        }
                    }
                }
            }
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return query;
    }
    /*
     * Command HQL query count rows. Jqgrid
     * Set paging start and stop.
     */

    public static Paging CountRows(SessionFactory sessionFactory, JqGridRequest req, String objectTable) {
        boolean isSearch = false;
        StringBuilder hql = new StringBuilder();
        String whereQuery = "";
        Search search;

        hql.append(CommandConstant.CountRows);
        hql.append(" ");
        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);

        if (req.isSearch()) {
            whereQuery = WhereQuery(req, true, "");
            if (!whereQuery.isEmpty()) {
                isSearch = true;
            }
            hql.append(whereQuery);
        }

        Paging paging = new Paging();
        Query query;
        try {
            System.out.print(hql.toString());
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());
            if (isSearch) {
                if (null != req.getSearchField()
                        && null != req.getSearchOper()
                        && null != req.getSearchString()
                        && !req.getSearchField().isEmpty()
                        && !req.getSearchOper().isEmpty()
                        && !req.getSearchString().isEmpty()) {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(req.getSearchOper())) {
                        query.setParameter(req.getSearchField(), req.getSearchString());
                    } else {
                        query.setParameter(req.getSearchField(), "%" + req.getSearchString() + "%");
                    }
                } else if (null != req.getSearchCommand() && !req.getSearchCommand().isEmpty()) {
                    search = new Search();
                    search = Search.JSONDeserializer(req.getSearchCommand());
                    for (Condition condition : search.getConditions()) {
                        if (null == condition.getJoinType() || condition.getJoinType().isEmpty()) {
                            if (CommandConstant.QueryBetween.equalsIgnoreCase(condition.getOp())) {
                                
                            }else{
                                if (CommandConstant.QueryEqual.equalsIgnoreCase(condition.getOp())) {
                                    if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                                        query.setParameter(condition.getField(), condition.getData());
                                    } else if (CommandConstant.DataTypeChar.equalsIgnoreCase(condition.getDataType())) {
                                        if (condition.getData().length() == 1) {
                                            query.setCharacter(condition.getField(), condition.getData().charAt(0));
                                        } else {
                                            query.setParameter(condition.getField(), condition.getData());
                                        }
                                    } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                                        query.setInteger(condition.getField(), null == condition.getData() ? 0 : Integer.valueOf(condition.getData().toString()));
                                    } else {
                                        query.setParameter(condition.getField(), condition.getData());
                                    }
                                } else {
                                    if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                                        query.setParameter(condition.getField(), "%" + condition.getData() + "%");
                                    } else if (CommandConstant.DataTypeChar.equalsIgnoreCase(condition.getDataType())) {
                                        if (condition.getData().length() == 1) {
                                            query.setCharacter(condition.getField(), condition.getData().charAt(0));
                                        } else {
                                            query.setParameter(condition.getField(), condition.getData());
                                        }
                                    } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                                        query.setInteger(condition.getField(), null == condition.getData() ? 0 : Integer.valueOf(condition.getData().toString()));
                                    } else {
                                        query.setParameter(condition.getField(), "%" + condition.getData() + "%");
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Number iRecords = (Number) query.uniqueResult();
            int startIndex = (req.getPage() - 1) * req.getRows();
            int endIndex = Math.min(startIndex + req.getRows(), iRecords.intValue());
            paging.setStartIndex(startIndex);
            paging.setEndIndex(endIndex);
            paging.setiRecords(iRecords.intValue());
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return paging;
    }

    /*
     * Command HQL query count rows. Jqgrid
     * Set paging start and stop.
     */
    public static Paging CountRows(SessionFactory sessionFactory, List<WhereField> listWhereField, String commandQuery, JqGridRequest req, String objectTable) {
        boolean isSearch = false;
        StringBuilder hql = new StringBuilder();
        String whereQuery = "";
        Search search;
        int iCount = 0;
        Boolean whereQueryControl = false;

        hql.append(CommandConstant.CountRows);
        hql.append(" ");
        hql.append(CommandConstant.QueryFrom);
        hql.append(" ");
        hql.append(objectTable);

        if (!listWhereField.isEmpty()) {
            hql.append(" ");
            hql.append(CommandConstant.QueryWhere);
            hql.append(" ");
            for (WhereField whereField : listWhereField) {
                if (0 != iCount) {
                    hql.append(" ");
                    hql.append(whereField.getSearchLogic());
                    hql.append(" ");
                }
                if (CommandConstant.QueryEqual.equalsIgnoreCase(whereField.getSearchOper())) {
                    hql.append(whereField.getSearchField()).append(" = :").append(whereField.getSearchField());
                } else {
                    hql.append(whereField.getSearchField()).append(" LIKE :").append(whereField.getSearchField());
                }
                iCount++;
            }
        }else{
            whereQueryControl = true;
        }

        if (req.isSearch()) {
            whereQuery = WhereQuery(req, whereQueryControl, commandQuery);
            if (!whereQuery.isEmpty()) {
                isSearch = true;
            }
            hql.append(whereQuery);
        }

        Paging paging = new Paging();
        Query query;
        try {
            System.out.print(hql.toString());
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());
            if (!listWhereField.isEmpty()) {
                for (WhereField whereField : listWhereField) {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(whereField.getSearchOper())) {
                        if (CommandConstant.DataTypeChar.equalsIgnoreCase(whereField.getSearchDataType())) {
                            if (whereField.getSearchValue().toString().length() == 1) {
                                query.setCharacter(whereField.getSearchField(), whereField.getSearchValue().toString().charAt(0));
                            } else {
                                query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                            }
                        } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(whereField.getSearchDataType())) {
                            query.setInteger(whereField.getSearchField(), null == whereField.getSearchValue() ? 0 : Integer.valueOf(whereField.getSearchValue().toString()));
                        } else {
                            query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                        }
                    } else {
                        if (CommandConstant.DataTypeChar.equalsIgnoreCase(whereField.getSearchDataType())) {
                            if (whereField.getSearchValue().toString().length() == 1) {
                                if (whereField.getSearchValue().toString().length() == 1) {
                                    query.setCharacter(whereField.getSearchField(), whereField.getSearchValue().toString().charAt(0));
                                } else {
                                    query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                                }
                            } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(whereField.getSearchDataType())) {
                                query.setInteger(whereField.getSearchField(), null == whereField.getSearchValue() ? 0 : Integer.valueOf(whereField.getSearchValue().toString()));
                            } else {
                                query.setParameter(whereField.getSearchField(), whereField.getSearchValue());
                            }
                        } else {
                            query.setParameter(whereField.getSearchField(), "%" + whereField.getSearchValue() + "%");
                        }
                    }
                }
            }
            if (isSearch) {
                if (null != req.getSearchField()
                        && null != req.getSearchOper()
                        && null != req.getSearchString()
                        && !req.getSearchField().isEmpty()
                        && !req.getSearchOper().isEmpty()
                        && !req.getSearchString().isEmpty()) {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(req.getSearchOper())) {
                        query.setParameter(req.getSearchField(), req.getSearchString());
                    } else {
                        query.setParameter(req.getSearchField(), "%" + req.getSearchString() + "%");
                    }
                } else if (null != req.getSearchCommand() && !req.getSearchCommand().isEmpty()) {
                    search = new Search();
                    search = Search.JSONDeserializer(req.getSearchCommand());
                    for (Condition condition : search.getConditions()) {
                        if (null == condition.getJoinType() || condition.getJoinType().isEmpty()) {
                            if (CommandConstant.QueryEqual.equalsIgnoreCase(condition.getOp())) {
                                if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                                    query.setParameter(condition.getField(), condition.getData());
                                } else if (CommandConstant.DataTypeChar.equalsIgnoreCase(condition.getDataType())) {
                                    if (condition.getData().length() == 1) {
                                        query.setCharacter(condition.getField(), condition.getData().charAt(0));
                                    } else {
                                        query.setParameter(condition.getField(), condition.getData());
                                    }
                                } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                                    query.setInteger(condition.getField(), null == condition.getData() ? 0 : Integer.valueOf(condition.getData().toString()));
                                } else {
                                    query.setParameter(condition.getField(), condition.getData());
                                }
                            } else {
                                if (CommandConstant.DataTypeVarchar.equalsIgnoreCase(condition.getDataType())) {
                                    query.setParameter(condition.getField(), "%" + condition.getData() + "%");
                                } else if (CommandConstant.DataTypeChar.equalsIgnoreCase(condition.getDataType())) {
                                    if (condition.getData().length() == 1) {
                                        query.setCharacter(condition.getField(), condition.getData().charAt(0));
                                    } else {
                                        query.setParameter(condition.getField(), condition.getData());
                                    }
                                } else if (CommandConstant.DataTypeInteger.equalsIgnoreCase(condition.getDataType())) {
                                    query.setInteger(condition.getField(), null == condition.getData() ? 0 : Integer.valueOf(condition.getData().toString()));
                                } else {
                                    query.setParameter(condition.getField(), "%" + condition.getData() + "%");
                                }
                            }
                        }
                    }
                }
            }

            Number iRecords = (Number) query.uniqueResult();
            int startIndex = (req.getPage() - 1) * req.getRows();
            int endIndex = Math.min(startIndex + req.getRows(), iRecords.intValue());
            paging.setStartIndex(startIndex);
            paging.setEndIndex(endIndex);
            paging.setiRecords(iRecords.intValue());
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return paging;
    }

    /*
     * Where Query Data.
     */
    private static String WhereQuery(JqGridRequest req, Boolean openWhere, String command) {
        StringBuilder hql = new StringBuilder();
        Search search;
        if (req.isSearch()) {
            //System.out.print(req.getSearchCommand());
            if (null != req.getSearchField()
                    && null != req.getSearchOper()
                    && null != req.getSearchString()
                    && !req.getSearchField().isEmpty()
                    && !req.getSearchOper().isEmpty()
                    && !req.getSearchString().isEmpty()) {
                hql.append(" ");
                if (openWhere) {
                    hql.append(CommandConstant.QueryWhere);
                } else {
                    hql.append(command);
                }
                hql.append(" ");
                if (CommandConstant.QueryBetween.equalsIgnoreCase(req.getSearchOper())) {
                    hql.append(req.getSearchField()).append(" between ");
                    hql.append(":beginDate and :endDate");
                } else {
                    if (CommandConstant.QueryEqual.equalsIgnoreCase(req.getSearchOper())) {
                        hql.append(req.getSearchField()).append(" = :").append(req.getSearchField());
                    } else {
                        hql.append(req.getSearchField()).append(" LIKE :").append(req.getSearchField());
                    }
                }
            } else if (null != req.getSearchCommand() && !req.getSearchCommand().isEmpty()) {
                search = new Search();
                search = Search.JSONDeserializer(req.getSearchCommand());
                hql.append(" ");
                if (openWhere) {
                    hql.append(CommandConstant.QueryWhere);
                } else {
                    hql.append(command);
                }
                hql.append(" ");
                for (Condition condition : search.getConditions()) {
                    if (null == condition.getJoinType() || condition.getJoinType().isEmpty()) {
                        if (CommandConstant.QueryAND.equalsIgnoreCase(condition.getGroupOp())) {
                            hql.append(" ");
                            hql.append(CommandConstant.QueryAND);
                        } else if (CommandConstant.QueryOR.equalsIgnoreCase(condition.getGroupOp())) {
                            hql.append(" ");
                            hql.append(CommandConstant.QueryOR);
                        } else {
                            hql.append("");
                        }
                        hql.append(" ");
                        if (CommandConstant.QueryBetween.equalsIgnoreCase(condition.getOp())) {
                            String[] tempDate = condition.getData().split(",");
                            String beginDate  = "";
                            String endDate    = "";
                            if(tempDate.length < 2 && CommandConstant.QueryBetween.equalsIgnoreCase(condition.getOp())){
                                beginDate = formatDate(tempDate[0]);
                                endDate = formatDate("");
                            }else{
                                beginDate = formatDate(tempDate[0]);
                                endDate = formatDate(tempDate[1]);
                            }
                            hql.append(condition.getField());
                            hql.append(" between ");
                            hql.append(" \'").append(beginDate).append("\' ");
                            hql.append(" and \'").append(endDate).append("\' ");
                        }else{
                            if (CommandConstant.QueryEqual.equalsIgnoreCase(condition.getOp())) {
                                hql.append(condition.getField()).append(" = :").append(condition.getField());
                            } else {
                                hql.append(condition.getField()).append(" LIKE :").append(condition.getField());
                            }
                        }
                    }
                }
            }
        }
        return hql.toString();
    }

    /*
     * Inset Data.
     * Set objectData.
     */
    public static boolean Insert(SessionFactory sessionFactory, Object objectData) {
        Session session = sessionFactory.getCurrentSession();
        boolean chekSuccess = false;
        try {
            //Save the data in database
            session.save(objectData);
            chekSuccess = true;
        } catch (HibernateException ex) {
            throw ex;
        }
        return chekSuccess;
    }

    /*
     * Approve Operation.
     * Set objectData.
     */
    public static boolean ApproveOperation(SessionFactory sessionFactory, int opermemid, int opertypecode, Date docdate, Date approvedate) {
        Session session = sessionFactory.getCurrentSession();
        boolean chekSuccess = false;
        try {
            String hql = "UPDATE Operation SET operation_type_code = :operation_type_code, doc_date = :doc_date, approval_date = :approval_date "
                    + "WHERE operation_id = :operation_id";
            //"FROM Operation AS OP, OperationMember AS OM " + 
            //"WHERE OP.operation_id = OM.operation_id and OM.operation_member_id = :operation_member_id";
            Query query = session.createQuery(hql);
            query.setParameter("operation_type_code", opertypecode);
            query.setParameter("doc_date", docdate);
            query.setParameter("approval_date", approvedate);
            query.setParameter("operation_id", opermemid);
            int result = query.executeUpdate();
            //Save the data in database
            //session.save(objectData);
            chekSuccess = true;
        } catch (HibernateException ex) {
            throw ex;
        }
        return chekSuccess;
    }

    /*
     * Approve Member.
     * Set objectData.
     */
    public static boolean ApproveMember(SessionFactory sessionFactory, int memberid, int memberstatuscode, Date updatedate) {
        Session session = sessionFactory.getCurrentSession();
        boolean chekSuccess = false;
        try {
            String hql = "UPDATE Member SET marry_status_code = :marry_status_code, update_date = :update_date "
                    + "WHERE member_id = :member_id";
            //"FROM Operation AS OP, OperationMember AS OM " + 
            //"WHERE OP.operation_id = OM.operation_id and OM.operation_member_id = :operation_member_id";
            Query query = session.createQuery(hql);
            query.setParameter("marry_status_code", memberstatuscode);
            query.setParameter("update_date", updatedate);
            query.setParameter("member_id", memberid);
            int result = query.executeUpdate();
            //Save the data in database
            //session.save(objectData);
            chekSuccess = true;
        } catch (HibernateException ex) {
            throw ex;
        }
        return chekSuccess;
    }

    /*
     * Update Data.
     * Set objectData.
     */
    public static boolean Update(SessionFactory sessionFactory, Object objectData) {
        Session session = sessionFactory.getCurrentSession();
        boolean chekSuccess = false;
        try {
            //Save the data in database
            session.update(objectData);
            chekSuccess = true;
        } catch (HibernateException ex) {
            throw ex;
        }
        return chekSuccess;
    }

    /*
     * Update Data.
     * Set objectData.
     */
    public static boolean Delete(SessionFactory sessionFactory, Object objectData) {
        Session session = sessionFactory.getCurrentSession();
        boolean chekSuccess = false;
        try {
            //Save the data in database
            session.delete(objectData);
            chekSuccess = true;
        } catch (HibernateException ex) {
            throw ex;
        }
        return chekSuccess;
    }

    /*
     * Load Detail Data.
     * Set objectData String.
     */
    public static Object LoadDetail(SessionFactory sessionFactory, Class classObject, String id) {
        Object objectOriginal;
        Session session = sessionFactory.getCurrentSession();
        try {
            objectOriginal = session.load(classObject, id);
        } catch (HibernateException ex) {
            throw ex;
        }
        return objectOriginal;
    }

    /*
     * Load Detail Data.
     * Set objectData int.
     */
    public static Object LoadDetail(SessionFactory sessionFactory, Class classObject, int id) {
        Object objectOriginal;
        Session session = sessionFactory.getCurrentSession();
        try {
            objectOriginal = session.load(classObject, id);
        } catch (HibernateException ex) {
            throw ex;
        }
        return objectOriginal;
    }

    public static Paging queryCountRows(SessionFactory sessionFactory, JqGridRequest req, StringBuilder hql) {

        Paging paging = new Paging();
        Query query;
        try {
            System.out.print(hql.toString());
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());

            Number iRecords = (Number) query.uniqueResult();
            int startIndex = (req.getPage() - 1) * req.getRows();
            int endIndex = Math.min(startIndex + req.getRows(), iRecords.intValue());
            paging.setStartIndex(startIndex);
            paging.setEndIndex(endIndex);
            paging.setiRecords(iRecords.intValue());
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return paging;
    }

    public static Query CreateQuery(SessionFactory sessionFactory, JqGridRequest req, Paging paging, StringBuilder hql) {

        hql.append(" ");
        hql.append(CommandConstant.OrderBy);
        hql.append(" ");
        hql.append(req.getSidx());
        hql.append(" ");
        hql.append(req.getSord());

        Query query;
        try {
            System.out.print(hql.toString());
            query = sessionFactory.getCurrentSession().createQuery(hql.toString());
            query.setFirstResult(paging.getStartIndex());
            query.setMaxResults(paging.getEndIndex());
        } catch (HibernateException exception) {
            throw exception;
        } finally {
            hql = null;
        }
        return query;
    }
    
    private static String formatDate(String date){
        
        if(date.isEmpty()){
            Date currentDate = DateUtil.getCurrentDate();
            String result = format.format(currentDate);
            return result;
        }
        try {
            Date tempDate =  sf.parse(date);
            String result = format.format(tempDate);
            return result;
        } catch (ParseException e) {
                e.printStackTrace();
        }
        return "";
    }
}
