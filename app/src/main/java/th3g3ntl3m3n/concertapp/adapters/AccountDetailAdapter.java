package th3g3ntl3m3n.concertapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import th3g3ntl3m3n.concertapp.R;
import th3g3ntl3m3n.concertapp.data.ClinicOne;
import th3g3ntl3m3n.concertapp.data.Constants;
import th3g3ntl3m3n.concertapp.interfaces.DataListener;

/**
 * Created by th3g3ntl3m3n on 16/8/17.
 */

public class AccountDetailAdapter
        extends RecyclerView.Adapter<AccountDetailAdapter.ViewHolder>
        implements DataListener {

    private static String TAG = AccountDetailAdapter.class.getSimpleName();
    public ArrayList<String> values;
    public String[] formValues;

    public AccountDetailAdapter(Context context) {
        int p = Constants.getPositionFromPrefs(context);
        Log.d(TAG, "AccountDetailAdapter: " + p);

        ClinicOne clinicOne = new ClinicOne();
        values = clinicOne.getClinicList(p);
        formValues = new String[values.size()];
    }

    @Override
    public String[] getData() {
        return formValues;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.edit_data_row, parent, false);

        return new ViewHolder(rootView, new CustomTextWatcher());
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.customTextWatcher.updatePosition(holder.getAdapterPosition());
        holder.fieldValue.setText(formValues[holder.getAdapterPosition()]);
        holder.fieldName.setText(values.get(position));
    }

    @Override
    public int getItemCount() {
        return formValues.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fieldName;
        public EditText fieldValue;
        public CustomTextWatcher customTextWatcher;

        ViewHolder(View rootView, CustomTextWatcher textWatcher) {
            super(rootView);
            this.fieldName = itemView.findViewById(R.id.fieldName);
            this.fieldValue = itemView.findViewById(R.id.fieldValue);
            this.customTextWatcher = textWatcher;
            this.fieldValue.addTextChangedListener(customTextWatcher);
        }
    }


    // we make TextWatcher to be aware of the position it currently works with
    // this way, once a new item is attached in onBindViewHolder, it will
    // update current position MyCustomEditTextListener, reference to which is kept by ViewHolder
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
            formValues[position] = charSequence.toString();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // no op
        }
    }
}
