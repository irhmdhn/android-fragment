package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnggotaInputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnggotaInputFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public AnggotaInputFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnggotaInputFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnggotaInputFragment newInstance(String param1, String param2) {
        AnggotaInputFragment fragment = new AnggotaInputFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    EditText inputNama, inputNim, inputProdi, inputEmail, inputTelp;
    Button btnSimpan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anggota_input, container, false);
        inputNama = view.findViewById(R.id.inputNama);
        inputNim = view.findViewById(R.id.inputNim);
        inputProdi = view.findViewById(R.id.inputProdi);
        inputEmail = view.findViewById(R.id.inputEmail);
        inputTelp = view.findViewById(R.id.inputTelp);
        btnSimpan = view.findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = inputNama.getText().toString();
                String nim = inputNim.getText().toString();
                String prodi = inputProdi.getText().toString();
                String email = inputEmail.getText().toString();
                String telp = inputTelp.getText().toString();

                AnggotaShowFragment anggotaShow = new AnggotaShowFragment();
                Bundle bundle = new Bundle();
                bundle.putString("nama", nama);
                bundle.putString("nim", nim);
                bundle.putString("prodi", prodi);
                bundle.putString("email", email);
                bundle.putString("telp", telp);
                anggotaShow.setArguments(bundle);

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.containerData, anggotaShow);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }

}