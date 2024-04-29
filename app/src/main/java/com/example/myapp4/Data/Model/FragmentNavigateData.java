package com.example.myapp4.Data.Model;

public class FragmentNavigateData {
    private String datafromFirstToList;
    private String datafromFirstToRecycler;
    public FragmentNavigateData()
    {
        this.datafromFirstToList="данные с фрагмента для лист";
        this.datafromFirstToRecycler="данные с фрагмента 1 для ресайклер";
    }

    public void setDatafromFirstToList(String datafromFirstToList)
    {this.datafromFirstToList=datafromFirstToList;}
    public void setDatafromFirstToRecycler(String datafromFirstToRecycler)
    {this.datafromFirstToRecycler=datafromFirstToRecycler;}
    public String getDatafromFirstToList(){return datafromFirstToList;}
    public String getDatafromFirstToRecycler(){return datafromFirstToRecycler;}
}
