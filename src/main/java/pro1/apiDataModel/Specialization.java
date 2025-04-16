package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Specialization {
    @SerializedName("programNazev")
    public String programName;
    @SerializedName("oborNazev")
    public String subject;
    @SerializedName("eprDeadlinePrihlaska")
    public Deadline datum;
}

