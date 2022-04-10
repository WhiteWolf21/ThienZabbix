package br.dev.kuhn.handyzabbix.graphs.pie_exploded;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;

public class PieExplodedViewManager extends SimpleViewManager<PieChart> {
    public static final String REACT_CLASS = "PieExplodedViewManager";

    private PieChart pieChart = null;

    private PieData pieData = null;

    private ThemedReactContext reactContext = null;

    private void setupGraphSettings() {
        PieChart pieChart = new PieChart((Context)this.reactContext);
        this.pieChart = pieChart;
        pieChart.setDescription(null);
        this.pieChart.getLegend().setEnabled(false);
        this.pieChart.setDrawHoleEnabled(false);
        this.pieChart.setRotationEnabled(false);
    }

    @ReactProp(name = "assembleData")
    public void assembleData(PieChart paramPieChart, ReadableMap paramReadableMap) {
        // Byte code:
        //   0: aload_2
        //   1: invokeinterface toHashMap : ()Ljava/util/HashMap;
        //   6: astore_1
        //   7: new java/util/ArrayList
        //   10: astore_2
        //   11: aload_2
        //   12: invokespecial <init> : ()V
        //   15: new java/util/ArrayList
        //   18: astore_3
        //   19: aload_3
        //   20: invokespecial <init> : ()V
        //   23: aload_1
        //   24: ldc 'graphItems'
        //   26: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
        //   29: checkcast java/util/List
        //   32: invokeinterface iterator : ()Ljava/util/Iterator;
        //   37: astore_1
        //   38: iconst_0
        //   39: istore #4
        //   41: fconst_0
        //   42: fstore #5
        //   44: fconst_0
        //   45: fstore #6
        //   47: iconst_1
        //   48: istore #7
        //   50: aload_1
        //   51: invokeinterface hasNext : ()Z
        //   56: ifeq -> 511
        //   59: aload_1
        //   60: invokeinterface next : ()Ljava/lang/Object;
        //   65: checkcast java/util/HashMap
        //   68: astore #8
        //   70: aload #8
        //   72: ldc 'color'
        //   74: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
        //   77: checkcast java/lang/String
        //   80: astore #9
        //   82: new java/lang/StringBuilder
        //   85: astore #10
        //   87: aload #10
        //   89: invokespecial <init> : ()V
        //   92: aload #10
        //   94: ldc '#'
        //   96: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   99: pop
        //   100: aload #10
        //   102: aload #9
        //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: pop
        //   108: aload #10
        //   110: invokevirtual toString : ()Ljava/lang/String;
        //   113: invokestatic parseColor : (Ljava/lang/String;)I
        //   116: istore #11
        //   118: aload #8
        //   120: ldc 'item'
        //   122: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
        //   125: checkcast java/lang/String
        //   128: astore #9
        //   130: aload #8
        //   132: ldc 'calc_fnc'
        //   134: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
        //   137: checkcast java/lang/String
        //   140: astore #9
        //   142: aload #8
        //   144: ldc 'type'
        //   146: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
        //   149: checkcast java/lang/String
        //   152: astore #10
        //   154: aload #10
        //   156: ldc '2'
        //   158: invokevirtual equals : (Ljava/lang/Object;)Z
        //   161: ifeq -> 174
        //   164: iload #11
        //   166: istore #7
        //   168: iconst_1
        //   169: istore #4
        //   171: goto -> 184
        //   174: aload_2
        //   175: iload #11
        //   177: invokestatic valueOf : (I)Ljava/lang/Integer;
        //   180: invokevirtual add : (Ljava/lang/Object;)Z
        //   183: pop
        //   184: aload #8
        //   186: ldc 'data'
        //   188: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
        //   191: checkcast java/util/List
        //   194: invokeinterface iterator : ()Ljava/util/Iterator;
        //   199: astore #8
        //   201: iconst_0
        //   202: istore #12
        //   204: fconst_0
        //   205: fstore #13
        //   207: aload #8
        //   209: invokeinterface hasNext : ()Z
        //   214: ifeq -> 412
        //   217: aload #8
        //   219: invokeinterface next : ()Ljava/lang/Object;
        //   224: checkcast java/util/HashMap
        //   227: ldc 'y'
        //   229: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
        //   232: checkcast java/lang/Double
        //   235: invokevirtual doubleValue : ()D
        //   238: d2f
        //   239: fstore #14
        //   241: fload #13
        //   243: fstore #15
        //   245: iload #12
        //   247: ifne -> 254
        //   250: fload #14
        //   252: fstore #15
        //   254: aload #9
        //   256: invokevirtual hashCode : ()I
        //   259: istore #11
        //   261: iload #11
        //   263: bipush #49
        //   265: if_icmpeq -> 317
        //   268: iload #11
        //   270: bipush #52
        //   272: if_icmpeq -> 301
        //   275: iload #11
        //   277: bipush #57
        //   279: if_icmpeq -> 285
        //   282: goto -> 333
        //   285: aload #9
        //   287: ldc '9'
        //   289: invokevirtual equals : (Ljava/lang/Object;)Z
        //   292: ifeq -> 333
        //   295: iconst_0
        //   296: istore #11
        //   298: goto -> 336
        //   301: aload #9
        //   303: ldc '4'
        //   305: invokevirtual equals : (Ljava/lang/Object;)Z
        //   308: ifeq -> 333
        //   311: iconst_1
        //   312: istore #11
        //   314: goto -> 336
        //   317: aload #9
        //   319: ldc '1'
        //   321: invokevirtual equals : (Ljava/lang/Object;)Z
        //   324: ifeq -> 333
        //   327: iconst_2
        //   328: istore #11
        //   330: goto -> 336
        //   333: iconst_m1
        //   334: istore #11
        //   336: iload #11
        //   338: ifeq -> 402
        //   341: iload #11
        //   343: iconst_1
        //   344: if_icmpeq -> 387
        //   347: iload #11
        //   349: iconst_2
        //   350: if_icmpeq -> 372
        //   353: fload #15
        //   355: fstore #13
        //   357: iload #12
        //   359: ifle -> 406
        //   362: fload #15
        //   364: fload #14
        //   366: fadd
        //   367: fstore #13
        //   369: goto -> 406
        //   372: fload #15
        //   374: fstore #13
        //   376: fload #15
        //   378: fload #14
        //   380: fcmpl
        //   381: ifle -> 406
        //   384: goto -> 402
        //   387: fload #15
        //   389: fstore #13
        //   391: fload #15
        //   393: fload #14
        //   395: fcmpg
        //   396: ifge -> 406
        //   399: goto -> 402
        //   402: fload #14
        //   404: fstore #13
        //   406: iinc #12, 1
        //   409: goto -> 207
        //   412: iload #12
        //   414: ifeq -> 499
        //   417: aload #9
        //   419: ldc '2'
        //   421: invokevirtual equals : (Ljava/lang/Object;)Z
        //   424: ifne -> 441
        //   427: fload #13
        //   429: fstore #15
        //   431: aload #9
        //   433: ldc '7'
        //   435: invokevirtual equals : (Ljava/lang/Object;)Z
        //   438: ifeq -> 449
        //   441: fload #13
        //   443: iload #12
        //   445: i2f
        //   446: fdiv
        //   447: fstore #15
        //   449: aload #10
        //   451: ldc '0'
        //   453: invokevirtual equals : (Ljava/lang/Object;)Z
        //   456: ifeq -> 492
        //   459: new com/github/mikephil/charting/data/PieEntry
        //   462: astore #8
        //   464: aload #8
        //   466: fload #15
        //   468: invokespecial <init> : (F)V
        //   471: aload_3
        //   472: aload #8
        //   474: invokevirtual add : (Ljava/lang/Object;)Z
        //   477: pop
        //   478: fload #6
        //   480: fload #15
        //   482: fadd
        //   483: fstore #6
        //   485: fload #5
        //   487: fstore #15
        //   489: goto -> 492
        //   492: fload #15
        //   494: fstore #5
        //   496: goto -> 50
        //   499: new java/lang/Exception
        //   502: astore_1
        //   503: aload_1
        //   504: ldc 'PieExplodedViewManager assembleData foundOne = false;'
        //   506: invokespecial <init> : (Ljava/lang/String;)V
        //   509: aload_1
        //   510: athrow
        //   511: iload #4
        //   513: ifeq -> 556
        //   516: fload #5
        //   518: fload #6
        //   520: fsub
        //   521: fstore #13
        //   523: fload #13
        //   525: fconst_0
        //   526: fcmpl
        //   527: ifle -> 556
        //   530: new com/github/mikephil/charting/data/PieEntry
        //   533: astore_1
        //   534: aload_1
        //   535: fload #13
        //   537: invokespecial <init> : (F)V
        //   540: aload_3
        //   541: aload_1
        //   542: invokevirtual add : (Ljava/lang/Object;)Z
        //   545: pop
        //   546: aload_2
        //   547: iload #7
        //   549: invokestatic valueOf : (I)Ljava/lang/Integer;
        //   552: invokevirtual add : (Ljava/lang/Object;)Z
        //   555: pop
        //   556: new com/github/mikephil/charting/data/PieDataSet
        //   559: astore_1
        //   560: aload_1
        //   561: aload_3
        //   562: ldc ''
        //   564: invokespecial <init> : (Ljava/util/List;Ljava/lang/String;)V
        //   567: aload_1
        //   568: aload_2
        //   569: invokevirtual setColors : (Ljava/util/List;)V
        //   572: new com/github/mikephil/charting/data/PieData
        //   575: astore_2
        //   576: aload_2
        //   577: aload_1
        //   578: invokespecial <init> : (Lcom/github/mikephil/charting/interfaces/datasets/IPieDataSet;)V
        //   581: aload_0
        //   582: aload_2
        //   583: putfield pieData : Lcom/github/mikephil/charting/data/PieData;
        //   586: aload_2
        //   587: iconst_0
        //   588: invokevirtual setDrawValues : (Z)V
        //   591: aload_0
        //   592: getfield pieChart : Lcom/github/mikephil/charting/charts/PieChart;
        //   595: aload_0
        //   596: getfield pieData : Lcom/github/mikephil/charting/data/PieData;
        //   599: invokevirtual setData : (Lcom/github/mikephil/charting/data/ChartData;)V
        //   602: aload_0
        //   603: getfield pieChart : Lcom/github/mikephil/charting/charts/PieChart;
        //   606: invokevirtual invalidate : ()V
        //   609: goto -> 651
        //   612: astore_1
        //   613: aload_0
        //   614: getfield pieChart : Lcom/github/mikephil/charting/charts/PieChart;
        //   617: aload_1
        //   618: invokevirtual toString : ()Ljava/lang/String;
        //   621: invokevirtual setNoDataText : (Ljava/lang/String;)V
        //   624: aload_0
        //   625: getfield pieChart : Lcom/github/mikephil/charting/charts/PieChart;
        //   628: ldc '#FF0000'
        //   630: invokestatic rgb : (Ljava/lang/String;)I
        //   633: invokevirtual setNoDataTextColor : (I)V
        //   636: aload_0
        //   637: getfield pieChart : Lcom/github/mikephil/charting/charts/PieChart;
        //   640: aconst_null
        //   641: invokevirtual setData : (Lcom/github/mikephil/charting/data/ChartData;)V
        //   644: aload_0
        //   645: getfield pieChart : Lcom/github/mikephil/charting/charts/PieChart;
        //   648: invokevirtual invalidate : ()V
        //   651: return
        // Exception table:
        //   from	to	target	type
        //   0	38	612	java/lang/Exception
        //   50	164	612	java/lang/Exception
        //   174	184	612	java/lang/Exception
        //   184	201	612	java/lang/Exception
        //   207	241	612	java/lang/Exception
        //   254	261	612	java/lang/Exception
        //   285	295	612	java/lang/Exception
        //   301	311	612	java/lang/Exception
        //   317	327	612	java/lang/Exception
        //   417	427	612	java/lang/Exception
        //   431	441	612	java/lang/Exception
        //   449	478	612	java/lang/Exception
        //   499	511	612	java/lang/Exception
        //   530	556	612	java/lang/Exception
        //   556	609	612	java/lang/Exception
    }

    protected PieChart createViewInstance(ThemedReactContext paramThemedReactContext) {
        this.reactContext = paramThemedReactContext;
        setupGraphSettings();
        return this.pieChart;
    }

    public String getName() {
        return "PieExplodedViewManager";
    }
}
