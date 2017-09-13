package th3g3ntl3m3n.concertapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.interfaces.AreaListener;


/**
 * Created by th3g3ntl3m3n on 29/8/17.
 */

public class PuskesmasAdapter
        extends RecyclerView.Adapter<PuskesmasAdapter.ViewHolder>
        implements AreaListener {

    private static final String TAG = PuskesmasAdapter.class.getSimpleName();
    private String[] data = new String[0];

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.puskesmas_row, parent, false);
        return new ViewHolder(view, new CustomTextWatcher());
    }

    public void updateRows(int n) {
        data = new String[n];
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.customTextWatcher.updatePosition(holder.getAdapterPosition());
        holder.pukesmasName.setText(data[holder.getAdapterPosition()]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public String[] getValue() {
        return data;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public CustomTextWatcher customTextWatcher;
        EditText pukesmasName;
        Button delete;

        public ViewHolder(View itemView, CustomTextWatcher customTextWatcher) {
            super(itemView);
            pukesmasName = itemView.findViewById(R.id.puskesmasName);
            this.customTextWatcher = customTextWatcher;
            delete = itemView.findViewById(R.id.deletePuskesmas);
            pukesmasName.addTextChangedListener(customTextWatcher);
        }
    }

    private class CustomTextWatcher implements TextWatcher {
        private int position;

        void updatePosition(int position) {
            this.position = position;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            // no op
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Log.d(TAG, "onTextChanged: " + position);
            data[position] = charSequence.toString();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // no op
        }
    }
}
