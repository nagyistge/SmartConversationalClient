package com.microsoft.pct.smartconversationalclient.common;

/*
A query result interface to be implemented by the different types of query results
 */
public interface IQueryResult {
    /*
    Gets the query that triggered this QueryResult
     */
    String getQuery();
}