package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SpecializationsList {
    @SerializedName("prijimaciObor")
    public List<Specialization> items;
}
