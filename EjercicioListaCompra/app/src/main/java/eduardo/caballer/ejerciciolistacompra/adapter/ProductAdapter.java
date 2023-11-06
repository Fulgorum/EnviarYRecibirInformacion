package eduardo.caballer.ejerciciolistacompra.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import eduardo.caballer.ejerciciolistacompra.R;
import eduardo.caballer.ejerciciolistacompra.modelos.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductVH> {
    private List<Product> objects;
    private int resource;
    private Context context;

    public ProductAdapter(List<Product> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productView = LayoutInflater.from(context).inflate(resource, null);

        productView.setLayoutParams(
                new RecyclerView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );
        return new ProductVH(productView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        Product product = objects.get(position);

        holder.lbName.setText(product.getName());
        holder.lbQuantity.setText(String.valueOf(product.getQuantity()));

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDelete(product).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProduct(product).show();
            }
        });
    }

    private AlertDialog updateProduct(Product product) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.titleUpdate);
        builder.setCancelable(false);

        View productModel = LayoutInflater.from(context).inflate(R.layout.product_view_model, null);
        EditText txtName = productModel.findViewById(R.id.txtNameProductViewModel);
        EditText txtQuantity = productModel.findViewById(R.id.txtQuantityProductViewModel);
        EditText txtPrice = productModel.findViewById(R.id.txtPriceProductViewModel);
        TextView lbTotal = productModel.findViewById(R.id.lbTotalProductViewModel);
        builder.setView(productModel);
        txtName.setText(product.getName());
        txtName.setEnabled(false);
        txtQuantity.setText(String.valueOf(product.getQuantity()));
        txtPrice.setText(String.valueOf(product.getPrice()));
        lbTotal.setText(String.valueOf(product.getTotal()));

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int quantity = Integer.parseInt(txtQuantity.getText().toString());
                    float price = Float.parseFloat(txtPrice.getText().toString());
                    float total = quantity * price;
                    lbTotal.setText(String.valueOf(total + " €"));
                } catch (Exception e) {

                }

            }
        };
        txtQuantity.addTextChangedListener(textWatcher);
        txtPrice.addTextChangedListener(textWatcher);

        builder.setNegativeButton(R.string.cancel, null);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (txtQuantity.getText().toString().isEmpty() || txtPrice.getText().toString().isEmpty()) {
                    Toast.makeText(context, R.string.missing, Toast.LENGTH_SHORT).show();
                } else {
                    product.setQuantity(Integer.parseInt(txtQuantity.getText().toString()));
                    product.setPrice(Float.parseFloat(txtPrice.getText().toString()));
                    notifyItemChanged(objects.indexOf(product));
                }
            }
        });
        return builder.create();
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    private AlertDialog confirmDelete(Product product) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.delete);
        builder.setCancelable(false);

        builder.setNegativeButton(R.string.cancel, null);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int position = objects.indexOf(product);
                objects.remove(product);
                notifyItemRemoved(position);

            }
        });
        return builder.create();
    }

    public class ProductVH extends RecyclerView.ViewHolder {
        TextView lbName, lbQuantity;
        ImageButton btnDelete;

        public ProductVH(@NonNull View itemView) {
            super(itemView);

            lbName = itemView.findViewById(R.id.lbNameViewHolder);
            lbQuantity = itemView.findViewById(R.id.lbQuantityProductViewHolder);
            btnDelete = itemView.findViewById(R.id.btnDeleteProductViewHolder);
        }
    }
}
