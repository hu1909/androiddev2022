package vn.edu.usth.email;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class EDetailFragment extends Fragment {
    private long contentId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_e_detail, container, false);
    }

    public void onStart(){
        super.onStart();
        View view = getView();
        if(view != null){
            TextView sender = (TextView) view.findViewById(R.id.textSender);
            TextView cont = (TextView) view.findViewById(R.id.textContent);
            Content content = Content.contents[(int) contentId];
            sender.setText(content.getSender());
            cont.setText(content.getContent());

        }
    }

    public void setContentId(long id){
        this.contentId = id;
    }
}