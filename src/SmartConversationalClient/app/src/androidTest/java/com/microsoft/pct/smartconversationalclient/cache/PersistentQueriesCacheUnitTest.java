package com.microsoft.pct.smartconversationalclient.cache;

import android.content.Context;
import android.test.InstrumentationTestCase;

import com.microsoft.pct.smartconversationalclient.luis.LUISQueryResult;

/**
 * Created by abornst on 6/16/2016.
 */
public class PersistentQueriesCacheUnitTest extends InstrumentationTestCase {

    private Context _context;
    private PersistentQueriesCache __persistentCache;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        _context = getInstrumentation().getTargetContext();
        __persistentCache = new PersistentQueriesCache(_context, LUISQueryResult.class);
        __persistentCache.init();
    }

    @Override
    protected void tearDown() throws Exception{
        __persistentCache.clear();
    }

    public void testPutAndMatch() throws Throwable
    {
        LUISQueryResult mockResult = new LUISQueryResult();
        mockResult.setQuery("Go to the Kitchen");

        __persistentCache.put(mockResult.getQuery(),mockResult);
        LUISQueryResult cached = (LUISQueryResult) __persistentCache.matchExact("Go to the Kitchen");

        assertEquals(mockResult.getQuery(),cached.getQuery());
    }

}