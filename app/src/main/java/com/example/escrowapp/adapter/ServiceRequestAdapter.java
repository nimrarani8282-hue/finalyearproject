package com.example.escrowapp.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.escrowapp.R;
import com.example.escrowapp.model.ServiceRequest;
import java.util.List;
import java.util.Locale;

public class ServiceRequestAdapter extends RecyclerView.Adapter<ServiceRequestAdapter.ViewHolder> {

    public interface Listener {
        void onAccept(ServiceRequest request, int position);
        void onReject(ServiceRequest request, int position);
    }

    private final List<ServiceRequest> requests;
    private final Listener listener;

    public ServiceRequestAdapter(List<ServiceRequest> requests, Listener listener) {
        this.requests = requests;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_service_request, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ServiceRequest req = requests.get(position);
        holder.tvClientName.setText(req.getClientName());
        holder.tvDescription.setText(String.format(Locale.US, "%s • $%,.2f",
                req.getDescription(), req.getAmount()));

        holder.btnAccept.setOnClickListener(v -> {
            if (listener != null) listener.onAccept(req, holder.getAdapterPosition());
        });
        holder.btnReject.setOnClickListener(v -> {
            if (listener != null) listener.onReject(req, holder.getAdapterPosition());
        });
    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvClientName, tvDescription, btnAccept, btnReject;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClientName = itemView.findViewById(R.id.tvClientName);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            btnAccept = itemView.findViewById(R.id.btnAccept);
            btnReject = itemView.findViewById(R.id.btnReject);
        }
    }
}
