package br.dev.kuhn.handyzabbix.graphs;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

import androidx.core.graphics.ColorUtils;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GraphViewManager extends SimpleViewManager<LineChart> {
    public static final String REACT_CLASS = "GraphViewManager";

    private LineChart lineChart = null;

    private LineData lineData = null;

    private ThemedReactContext reactContext = null;

    private void setupGraphSettings() {
        LineChart lineChart = new LineChart((Context)this.reactContext);
        this.lineChart = lineChart;
        lineChart.getLegend().setEnabled(false);
        this.lineChart.setScaleEnabled(false);
        this.lineChart.setDoubleTapToZoomEnabled(false);
        this.lineChart.setDescription(null);
        this.lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        this.lineChart.setDrawBorders(false);
    }

    @ReactProp(name = "assembleData")
    public void assembleData(LineChart paramLineChart, ReadableMap paramReadableMap) {
        try {
            HashMap hashMap = paramReadableMap.toHashMap();
            int i = Color.parseColor((String)hashMap.get("labelColor"));
            String str3 = (String)hashMap.get("yaxisLeftUnit");
            String str4 = (String)hashMap.get("yaxisRightUnit");
            List list1 = (List)hashMap.get("xLabels");
            String str1 = (String)hashMap.get("ymin_type");
            String str2 = (String)hashMap.get("ymax_type");
            List list2 = (List)hashMap.get("graphItems");
            ArrayList<LineDataSet> arrayList = new ArrayList();
            this();
            Iterator<HashMap> iterator = list2.iterator();
            boolean bool1 = false;
            float f1 = 0.0F;
            float f2 = 0.0F;
            boolean bool2 = false;
            while (true) {
                boolean bool = iterator.hasNext();
                if (bool) {
                    HashMap hashMap1 = iterator.next();
                    String str5 = (String)hashMap1.get("yaxisside");
                    String str6 = (String)hashMap1.get("drawtype");
                    String str7 = (String)hashMap1.get("color");
                    StringBuilder stringBuilder = new StringBuilder();
                    this();
                    stringBuilder.append("#");
                    stringBuilder.append(str7);
                    int j = Color.parseColor(stringBuilder.toString());
                    str7 = (String)hashMap1.get("item");
                    List list = (List)hashMap1.get("data");
                    ArrayList<Entry> arrayList1 = new ArrayList();
                    this();
                    Iterator<HashMap> iterator1 = list.iterator();
                    float f = 0.0F;
                    int k = i;
                    while (iterator1.hasNext()) {
                        HashMap hashMap2 = iterator1.next();
                        i = (int)((Double)hashMap2.get("x")).doubleValue();
                        float f3 = (float)((Double)hashMap2.get("y")).doubleValue();
                        float f4 = f;
                        if (f3 < f)
                            f4 = f3;
                        Entry entry = new Entry();
                        this(i, f3);
                        arrayList1.add(entry);
                        f = f4;
                    }
                    LineDataSet lineDataSet = new LineDataSet();
                    this(arrayList1, str7);
                    lineDataSet.setColor(j);
                    lineDataSet.setDrawCircles(false);
                    i = -1;
                    switch (str6.hashCode()) {
                        case 53:
                            if (str6.equals("5"))
                                i = 4;
                            break;
                        case 52:
                            if (str6.equals("4"))
                                i = 3;
                            break;
                        case 51:
                            if (str6.equals("3"))
                                i = 2;
                            break;
                        case 50:
                            if (str6.equals("2"))
                                i = 1;
                            break;
                        case 49:
                            if (str6.equals("1"))
                                i = 0;
                            break;
                    }
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    if (i != 4) {
                                        lineDataSet.setLineWidth(1.0F);
                                    } else {
                                        i = ColorUtils.blendARGB(j, 0, 0.6F);
                                        GradientDrawable gradientDrawable = new GradientDrawable();
                                        this(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { j, i });
                                        lineDataSet.setFillDrawable((Drawable)gradientDrawable);
                                        lineDataSet.setDrawFilled(true);
                                    }
                                } else {
                                    lineDataSet.enableDashedLine(8.0F, 3.0F, 2.0F);
                                }
                            } else {
                                lineDataSet.enableDashedLine(3.0F, 4.0F, 3.0F);
                            }
                        } else {
                            lineDataSet.setLineWidth(3.0F);
                        }
                    } else {
                        lineDataSet.setDrawFilled(true);
                        lineDataSet.setFillColor(j);
                    }
                    if (str5.equals("0")) {
                        float f3 = f1;
                        if (f < f1)
                            f3 = f;
                        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
                        bool1 = true;
                        f1 = f3;
                    } else {
                        float f3 = f2;
                        if (f < f2)
                            f3 = f;
                        lineDataSet.setAxisDependency(YAxis.AxisDependency.RIGHT);
                        bool2 = true;
                        f2 = f3;
                    }
                    arrayList.add(lineDataSet);
                    i = k;
                    continue;
                }
                LineData lineData = new LineData();
                this(arrayList);
                this.lineData = lineData;
                lineData.setDrawValues(false);
                YAxis yAxis2 = this.lineChart.getAxisLeft();
                YAxis yAxis1 = this.lineChart.getAxisRight();
                DecimalFormat decimalFormat = new DecimalFormat();
                this("###,###,##0.00");
                if (bool1) {
                    if (str1.equals("1")) {
                        yAxis2.setAxisMinimum((float)((Double)hashMap.get("yaxisminLeft")).doubleValue());
                    } else {
                        yAxis2.setAxisMinimum(f1);
                    }
                    if (str2.equals("1"))
                        yAxis2.setAxisMaximum((float)((Double)hashMap.get("yaxismaxLeft")).doubleValue());
                    yAxis2.setTextColor(i);
                    ValueFormatter valueFormatter = new ValueFormatter() {
                        public String getFormattedValue(float param1Float) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(mFormat.format(param1Float));
                            stringBuilder.append(" ");
                            stringBuilder.append(yaxisLeftUnit);
                            return stringBuilder.toString();
                        }
                    };
                    super(this, decimalFormat, str3);
                    yAxis2.setValueFormatter(valueFormatter);
                } else {
                    yAxis2.setDrawLabels(false);
                }
                if (bool2) {
                    if (str1.equals("1")) {
                        yAxis1.setAxisMinimum((float)((Double)hashMap.get("yaxisminRight")).doubleValue());
                    } else {
                        yAxis1.setAxisMinimum(f2);
                    }
                    if (str2.equals("1"))
                        yAxis1.setAxisMaximum((float)((Double)hashMap.get("yaxismaxRight")).doubleValue());
                    yAxis1.setTextColor(i);
                    ValueFormatter valueFormatter = new ValueFormatter() {
                        public String getFormattedValue(float param1Float) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(mFormat.format(param1Float));
                            stringBuilder.append(" ");
                            stringBuilder.append(yaxisRightUnit);
                            return stringBuilder.toString();
                        }
                    };
                    super(this, decimalFormat, str4);
                    yAxis1.setValueFormatter(valueFormatter);
                } else {
                    yAxis1.setDrawLabels(false);
                }
                XAxis xAxis = this.lineChart.getXAxis();
                IndexAxisValueFormatter indexAxisValueFormatter = new IndexAxisValueFormatter();
                this(list1);
                xAxis.setValueFormatter((ValueFormatter)indexAxisValueFormatter);
                xAxis.setLabelRotationAngle(-90.0F);
                xAxis.setLabelCount(list1.size());
                xAxis.setGranularityEnabled(true);
                xAxis.setTextColor(i);
                this.lineChart.setData((ChartData)this.lineData);
                this.lineChart.invalidate();
                this.lineChart.setVisibleXRangeMaximum(8.0F);
                return;
            }
        } catch (Exception exception) {
            this.lineChart.setNoDataText(exception.toString());
            this.lineChart.setNoDataTextColor(ColorTemplate.rgb("#FF0000"));
            this.lineChart.setData(null);
            this.lineChart.invalidate();
        }
    }

    protected LineChart createViewInstance(ThemedReactContext paramThemedReactContext) {
        this.reactContext = paramThemedReactContext;
        setupGraphSettings();
        return this.lineChart;
    }

    public String getName() {
        return "GraphViewManager";
    }
}