package br.dev.kuhn.handyzabbix.expo.modules.interfaces.facedetector;

import android.os.Bundle;
import java.util.ArrayList;

public interface FacesDetectionCompleted {
    void detectionCompleted(ArrayList<Bundle> arrayList);
}
