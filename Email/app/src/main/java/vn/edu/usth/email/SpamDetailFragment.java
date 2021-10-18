package vn.edu.usth.email;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SpamDetailFragment extends Fragment {

    private long spamId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_spam_detail, container, false);
    }
    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if(view != null){
            TextView spammer = (TextView) view.findViewById(R.id.textSpammer);
            TextView spamcont = (TextView) view.findViewById(R.id.textSpamContent);
            Spamcontent sc = Spamcontent.spamcontents[(int) spamId];
            spammer.setText(sc.getSpammer());
            spamcont.setText(sc.getSpamcontent());

        }
    }
    public void setSpamId(long id){ this.spamId = id; }
}