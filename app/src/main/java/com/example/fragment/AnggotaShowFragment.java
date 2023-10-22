package com.example.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnggotaShowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnggotaShowFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnggotaShowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnggotaShowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnggotaShowFragment newInstance(String param1, String param2) {
        AnggotaShowFragment fragment = new AnggotaShowFragment();
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
    private TextView tvNama,tvNim,tvProdi,tvEmail,tvTelp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_anggota_show,container,false);
        tvNama = view.findViewById(R.id.tvNama);
        tvNim = view.findViewById(R.id.tvNim);
        tvProdi = view.findViewById(R.id.tvProdi);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvTelp = view.findViewById(R.id.tvTelp);

        Bundle bundle = getArguments();
        if(bundle != null){
            String nama = bundle.getString("nama");
            String nim = bundle.getString("nim");
            String prodi = bundle.getString("prodi");
            String email = bundle.getString("email");
            String telp = bundle.getString("telp");

            if (nama != null) {
                tvNama.setText(nama);
            }
            if (nim != null) {
                tvNim.setText(nim);
            }
            if (prodi != null) {
                tvProdi.setText(prodi);
            }
            if (email != null) {
                tvEmail.setText(email);
            }
            if (telp != null) {
                tvTelp.setText(telp);
            }
        }

        return view;
    }
}