package com.tequila.mommy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.anwarshahriar.calligrapher.Calligrapher;

public class MainActivity extends AppCompatActivity {

    String t;
    String n;
    String m;
    String tIs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t();
        n();
        m();

        FloatingActionButton fabEsta = findViewById(R.id.fabEsta);

        fabEsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((t != null && !t.isEmpty()) && (n != null && !n.isEmpty()) && (m != null && !m.isEmpty())) {
                    if (t.equals("TX") || n.equals("NX") || m.equals("MX")) {
                        toast("No se puede dar algún tratamiento ya que no están completos los estudios");
                    } else {
                        String type;
                        if (m.equals("M1")) {
                            type = "4";
                        } else {
                            if (n.equals("N3")) {
                                type = "3";
                            } else {
                                if (t.equals("T4")) {
                                    type = "3";
                                } else {
                                    type = t + n + m;
                                    switch (type) {
                                        case "TisN0M0":
                                            type = "0";
                                            break;
                                        case "T0N0M0":
                                            type = "0";
                                            break;
                                        case "T1N0M0":
                                            type = "1";
                                            break;
                                        case "T0N1M0":
                                            type = "2";
                                            break;
                                        case "T1N1M0":
                                            type = "2";
                                            break;
                                        case "T2N0M0":
                                            type = "2";
                                            break;
                                        case "T2N1M0":
                                            type = "2";
                                            break;
                                        case "T3N0M0":
                                            type = "2";
                                            break;
                                        default:
                                            type = "3";
                                            break;
                                    }
                                }
                            }
                        }
                        //toast(t + n + m + "\n" + "ETAPA: " + type);
                        initViewResult(type);
                    }


                } else {
                    toast("Favor de Llenar el Cuestionario");
                }
            }
        });
    }


    private void t() {
        final RadioGroup rdgT = findViewById(R.id.rdgT);
        final RadioGroup rdgIs = findViewById(R.id.rdgIs);
        rdgIs.setVisibility(View.GONE);
        final RadioGroup rdgT4 = findViewById(R.id.rdgT4);
        rdgT4.setVisibility(View.GONE);
        final EditText edtT = findViewById(R.id.edtSizeT);

        edtT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //rdgT.clearCheck();
                rdgIs.setVisibility(View.GONE);
                tIs = null;
                if (!s.toString().isEmpty()) {
                    float cm = Integer.parseInt(s.toString());
                    if (cm <= 2) {
                        t = "T1";
                        rdgT4.setVisibility(View.GONE);
                    } else if (cm < 5) {
                        t = "T2";
                        rdgT4.setVisibility(View.GONE);
                    } else if (cm >= 5) {
                        t = "T3";
                        rdgT4.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        rdgT.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rdgT4.setVisibility(View.GONE);
                switch (checkedId) {
                    case R.id.rdTX:
                        // do operations specific to this selection
                        t = "TX";
                        edtT.setText("");
                        rdgIs.setVisibility(View.GONE);
                        tIs = null;
                        break;

                    case R.id.rdT0:
                        // do operations specific to this selection
                        t = "T0";
                        edtT.setText("");
                        rdgIs.setVisibility(View.GONE);
                        tIs = null;
                        break;

                    case R.id.rdTIs:
                        // do operations specific to this selection
                        t = "Tis";
                        edtT.setText("");
                        rdgIs.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        rdgT4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                t = "T4";
                switch (checkedId) {
                    case R.id.rdT4A:
                        // do operations specific to this selection
                        break;

                    case R.id.rdT4B:
                        // do operations specific to this selection
                        break;

                    case R.id.rdT4C:
                        // do operations specific to this selection
                        break;
                    case R.id.rdT4D:
                        // do operations specific to this selection
                        break;
                }
            }
        });

        rdgIs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdDCIS:
                        // do operations specific to this selection
                        tIs = "DCIS";
                        break;

                    case R.id.rdLCIS:
                        // do operations specific to this selection
                        tIs = "LCIS";
                        break;

                    case R.id.rdPaguet:
                        // do operations specific to this selection
                        tIs = "Paguet";
                        break;
                }
            }
        });
    }

    private void n() {
        final RadioGroup rdgN = findViewById(R.id.rdgN);
        final EditText edtN = findViewById(R.id.edtN);
        final RadioGroup rdgN0 = findViewById(R.id.rdgN0);
        rdgN0.setVisibility(View.GONE);
        final RadioGroup rdgN1 = findViewById(R.id.rdgN1);
        rdgN1.setVisibility(View.GONE);
        final RadioGroup rdgN2 = findViewById(R.id.rdgN2);
        rdgN2.setVisibility(View.GONE);
        final RadioGroup rdgN3 = findViewById(R.id.rdgN3);
        rdgN3.setVisibility(View.GONE);

        edtN.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().isEmpty()) {
                    rdgN.clearCheck();
                    int num = Integer.parseInt(s.toString());
                    if (num >= 1 && num <= 3) {
                        rdgN0.setVisibility(View.GONE);
                        rdgN3.setVisibility(View.GONE);
                        rdgN2.setVisibility(View.GONE);
                        rdgN1.setVisibility(View.VISIBLE);
                        n = "N1";

                    } else if (num >= 4 && num <= 9) {
                        rdgN0.setVisibility(View.GONE);
                        rdgN1.setVisibility(View.GONE);
                        rdgN3.setVisibility(View.GONE);
                        rdgN2.setVisibility(View.VISIBLE);
                        n = "N2";

                    } else if (num >= 10) {
                        rdgN0.setVisibility(View.GONE);
                        rdgN1.setVisibility(View.GONE);
                        rdgN2.setVisibility(View.GONE);
                        rdgN3.setVisibility(View.VISIBLE);
                        n = "N3";

                    } else {
                        rdgN.check(R.id.rdN0);
                    }
                } else {
                    rdgN1.setVisibility(View.GONE);
                    rdgN2.setVisibility(View.GONE);
                    rdgN3.setVisibility(View.GONE);
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        rdgN.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdNX:
                        // do operations specific to this selection
                        rdgN3.setVisibility(View.GONE);
                        rdgN1.setVisibility(View.GONE);
                        rdgN2.setVisibility(View.GONE);
                        rdgN0.setVisibility(View.GONE);
                        n = "NX";
                        edtN.setText("");
                        break;
                    case R.id.rdN0:
                        // do operations specific to this selection
                        n = "N0";
                        rdgN3.setVisibility(View.GONE);
                        rdgN1.setVisibility(View.GONE);
                        rdgN2.setVisibility(View.GONE);
                        rdgN0.setVisibility(View.VISIBLE);
                        edtN.setText("");
                        break;
                }
            }
        });

    }

    private void m() {
        RadioGroup rdgT = findViewById(R.id.rdgM);

        rdgT.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdMx:
                        // do operations specific to this selection
                        m = "MX";
                        break;

                    case R.id.rdM0:
                        // do operations specific to this selection
                        m = "M0";
                        break;

                    case R.id.rdM1:
                        // do operations specific to this selection
                        m = "M1";
                        break;
                }
            }
        });
    }

    public void toast(String message) {

        Typeface futura = Typeface.createFromAsset(getAssets(), Constants.FUTURA);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        TextView tv = new TextView(getApplicationContext());
        tv.setBackground(getDrawable(android.R.drawable.toast_frame));
        tv.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimaryDark)));
        tv.setTextColor(getResources().getColor(android.R.color.white));
        tv.setTextSize(18);
        tv.setTypeface(futura);
        tv.setText(message);
        toast.setView(tv);
        toast.show();

    }

    private void initViewResult(String type) {


        final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.etapa, null);


        dialogBuilder.setView(dialogView);

        Button btnEtapa = dialogView.findViewById(R.id.btnEtapa);
        TextView txtTitle = dialogView.findViewById(R.id.txtTitle);


        Typeface futura = Typeface.createFromAsset(getAssets(), Constants.FUTURA);
        btnEtapa.setTypeface(futura);
        txtTitle.setTypeface(futura);
        btnEtapa.setText("ETAPA "+ type);


        ArrayList<Tratamiento> opciones = new ArrayList<>();


        LinearLayout layout = dialogView.findViewById(R.id.layTrat);
        switch (type){
            case "0":
                if(tIs != null){
                    switch (tIs){
                        case "DCIS":
                            Tratamiento tratamiento18 = new Tratamiento("Cirugía con conservación del seno","En la cirugía con conservación del seno, el cirujano extirpa el tumor y una pequeña cantidad de tejido mamario normal alrededor de él. En la cirugía con conservación del seno, la extirpación de ganglios linfáticos no es siempre necesario, pero se puede hacer si el médico cree que la zona de DCIS también puede contener cáncer invasivo.");
                            Tratamiento tratamiento19 = new Tratamiento("Mastectomía","Es posible que se requiera una mastectomía simple (extirpación total de un seno) si el área con DCIS es muy grande.");
                            Tratamiento tratamiento20 = new Tratamiento("Terapia hormonal después de la cirugía","Si se trata de un DCIS con receptores de hormonas positivos (ER-positivo o PR-positivo), el tratamiento adyuvante con tamoxifeno (para cualquier mujer) o un inhibidor de la aromatasa (para las mujeres posmenopáusicas) por 5 años después de la cirugía puede reducir el riesgo de otro DCIS o de cáncer invasivo que se origina en cualquiera de los senos.");
                            opciones.add(tratamiento18);
                            opciones.add(tratamiento19);
                            opciones.add(tratamiento20);
                            break;
                        case "LCIS":
                            Tratamiento tratamiento21 = new Tratamiento("Terapia hormonal","Si usted tiene LCIS, puede que desee considerar tomar un medicamento hormonal, como tamoxifeno, raloxifeno, o inhibidores de la aromatasa para ayudar a reducir su riesgo de padecer cáncer de seno. ");
                            opciones.add(tratamiento21);
                            break;
                        case "Paguet":
                            Tratamiento tratamiento22 = new Tratamiento("Mastectomía","La enfermedad de Paget puede tratarse mediante la extirpación de todo el seno (mastectomía) o cirugía con conservación del seno seguida de radioterapia a todo el seno.");
                            opciones.add(tratamiento22);
                            break;
                    }
                }
                else{
                    Tratamiento tratamiento17 = new Tratamiento("Cuidados","En el estadio 0, no hay indicios de células cancerígenas o células anómalas no cancerosas que salen de la zona de la mama en la que se originaron o que toman o invaden tejidos normales circundantes.");
                    opciones.add(tratamiento17);
                }

                break;
            case "1":
                Tratamiento tratamiento = new Tratamiento("Cirugía","");
                Tratamiento tratamiento2 = new Tratamiento("Radioterapia","");
                Tratamiento tratamiento3 = new Tratamiento("Radioterapia","");
                opciones.add(tratamiento);
                opciones.add(tratamiento2);
                opciones.add(tratamiento3);
                break;
            case "2":
                Tratamiento tratamiento4 = new Tratamiento("Terapia local (cirugía y radioterapia)","Los cánceres en etapa II pueden tratarse con cirugía con conservación del seno (a veces llamada tumorectomía o mastectomía parcial) o mastectomía");
                Tratamiento tratamiento5 = new Tratamiento("Terapia neoadyuvante y adyuvante (quimioterapia y otros medicamentos)","");
                Tratamiento tratamiento6 = new Tratamiento("Quimioterapia","");
                Tratamiento tratamiento7 = new Tratamiento("Medicamentos dirigidos a HER2","");
                Tratamiento tratamiento8 = new Tratamiento("Terapia hormonal","");

                opciones.add(tratamiento4);
                opciones.add(tratamiento5);
                opciones.add(tratamiento6);
                opciones.add(tratamiento7);
                opciones.add(tratamiento8);
                break;
            case "3":
                Tratamiento tratamiento9 = new Tratamiento("Comenzar con terapia neoadyuvante","Con más frecuencia, estos cánceres se tratan con quimioterapia neoadyuvante (antes de la cirugía)");
                Tratamiento tratamiento10 = new Tratamiento("Comenzar con cirugía","");
                opciones.add(tratamiento9);
                opciones.add(tratamiento10);

                break;
            case "4":
                Tratamiento tratamiento11 = new Tratamiento("Terapia hormonal","");
                Tratamiento tratamiento12 = new Tratamiento("Quimioterapia (quimio)","");
                Tratamiento tratamiento13 = new Tratamiento("Medicamentos de terapia dirigida, como el trastuzumab (Herceptin) y el pertuzumab (Perjeta)","");
                Tratamiento tratamiento14 = new Tratamiento("Tratamientos sistémicos (medicamento)","");
                Tratamiento tratamiento15 = new Tratamiento("Cirugía","");
                Tratamiento tratamiento16 = new Tratamiento("Radioterapia","");

                opciones.add(tratamiento11);
                opciones.add(tratamiento12);
                opciones.add(tratamiento13);
                opciones.add(tratamiento14);
                opciones.add(tratamiento15);
                opciones.add(tratamiento16);
                break;

        }

        for(Tratamiento trat:opciones){
            TextComp textView = new TextComp(getApplicationContext(),layout);
            layout.addView(textView.getTitle(trat.getTopic()));
            layout.addView(textView.getCont(trat.getSubTopic()));
        }


        final AlertDialog alertDialog = dialogBuilder.setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_NEUTRAL:
                        break;
                }
            }
        }).create();
        alertDialog.show();
        Button buttonAlert = alertDialog.findViewById(android.R.id.button3);
        buttonAlert.setTypeface(futura);
        buttonAlert.setTextSize(20);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, Constants.FUTURA, true);
    }
}
