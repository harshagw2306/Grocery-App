package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.groceryapp.Adapters.GS_Recy_View_Adapter;

import java.io.Serializable;
import java.util.ArrayList;

public class SubList extends AppCompatActivity implements GS_Recy_View_Adapter.OnItemListener {

    int i,p=0;
    Button check_out;
    ArrayList<Sub_Category_Item_Model> sub_grocerymodels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_list);
        p = getIntent().getExtras().getInt("Position");
        check_out = (Button) findViewById(R.id.check_out_button);
        if(getIntent().hasExtra("True"))
        {
            Toast.makeText(SubList.this, "Cart is loaded !", Toast.LENGTH_SHORT).show();
            check_out.setVisibility(View.VISIBLE);
        }
        setupSubGroceryModels(p);
        RecyclerView child_recyclerView = findViewById(R.id.My_Child_Rec_View);
        GS_Recy_View_Adapter adapter = new GS_Recy_View_Adapter(this, sub_grocerymodels, this);
        child_recyclerView.setAdapter(adapter);
        child_recyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
        check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item_Activity ob = new Item_Activity();
                Intent intent = new Intent(SubList.this, Checkout_Activity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Final items",(Serializable) ob.Items);
                intent.putExtra("Bundle",bundle);
                startActivity(intent);
            }
        });
    }

    private void setupSubGroceryModels(int p) {
//        int[] grocery_sub_category_images= {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,
//                R.drawable.image5,R.drawable.image6,R.drawable.image7,R.drawable.image8,
//                R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12,
//                R.drawable.image13,R.drawable.image14,R.drawable.image15,R.drawable.image16,
//                R.drawable.image17,R.drawable.image18,R.drawable.image19,R.drawable.image20,
//                R.drawable.image21,R.drawable.image22,R.drawable.image23,R.drawable.image24,
//                R.drawable.image25,R.drawable.image26,R.drawable.image27,R.drawable.image28,
//                R.drawable.image29,R.drawable.image30,R.drawable.image31,R.drawable.image32,
//                R.drawable.image33,R.drawable.image34,R.drawable.image35,R.drawable.image36};
        int[] grocery_sub_category_images={R.drawable.flour,R.drawable.ghee,R.drawable.rava,R.drawable.kuttu_aata,
                R.drawable.lentils_rice,R.drawable.dry_fruits,R.drawable.sugar,
                R.drawable.tea,R.drawable.spices,R.drawable.gluten_free_snacks,
                R.drawable.rajastani_sabjiya,R.drawable.milk_powder,R.drawable.frozen_fruits,
                R.drawable.chocoloate_makers,R.drawable.mocktails,R.drawable.shakes,
                R.drawable.baking,R.drawable.sauces,R.drawable.pizza,R.drawable.frozen_items,
                R.drawable.frozen_cook,R.drawable.tinned_fruits,R.drawable.chinese_items};
        if(p == 0)
        {
            String[] grocery_sub_category_atta= getResources().getStringArray(R.array.sub_list_category_atta);
            for(i=0;i<=((grocery_sub_category_atta.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_atta[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 1)
        {
            String[] grocery_sub_category_ghee= getResources().getStringArray(R.array.sub_list_category_ghee);
            for(i=0;i<=((grocery_sub_category_ghee.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_ghee[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 2)
        {
            String[] grocery_sub_category_rava= getResources().getStringArray(R.array.sub_list_category_rava);
            for(i=0;i<=((grocery_sub_category_rava.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_rava[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 3)
        {
            String[] grocery_sub_category_vrat_atta= getResources().getStringArray(R.array.sub_list_category_vrat_atta);
            for(i=0;i<=((grocery_sub_category_vrat_atta.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_vrat_atta[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 4)
        {
            String[] grocery_sub_category_rice= getResources().getStringArray(R.array.sub_list_category_rice);
            for(i=0;i<=((grocery_sub_category_rice.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_rice[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 5)
        {
            String[] grocery_sub_category_dal= getResources().getStringArray(R.array.sub_list_category_dal);
            for(i=0;i<=((grocery_sub_category_dal.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_dal[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 6)
        {
            String[] grocery_sub_category_pulse= getResources().getStringArray(R.array.sub_list_category_pulse);
            for(i=0;i<=((grocery_sub_category_pulse.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_pulse[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 7)
        {
            String[] grocery_sub_category_dry_fruit_nut= getResources().getStringArray(R.array.sub_list_category_dry_fruit_nut);
            for(i=0;i<=((grocery_sub_category_dry_fruit_nut.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_dry_fruit_nut[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 8)
        {
            String[] grocery_sub_category_chini= getResources().getStringArray(R.array.sub_list_category_chini);
            for(i=0;i<=((grocery_sub_category_chini.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_chini[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 9)
        {
            String[] grocery_sub_category_tea= getResources().getStringArray(R.array.sub_list_category_tea);
            for(i=0;i<=((grocery_sub_category_tea.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_tea[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 10)
        {
            String[] grocery_sub_category_spice= getResources().getStringArray(R.array.sub_list_category_spice);
            for(i=0;i<=((grocery_sub_category_spice.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_spice[i],grocery_sub_category_images[i]));
            }
        }
        if(p == 11)
        {
            String[] grocery_sub_category_gluten_free= getResources().getStringArray(R.array.sub_list_category_gluten_free);
            for(i=0;i<=((grocery_sub_category_gluten_free.length)-1);i++)
            {
                sub_grocerymodels.add(new Sub_Category_Item_Model(grocery_sub_category_gluten_free[i],grocery_sub_category_images[i]));
            }
        }
    }

    @Override
    public void OnItemClick(int image, String s)
    {
        Intent intent = new Intent(SubList.this, Item_Activity.class);
        intent.putExtra("Image", image);
        intent.putExtra("String", s);
        startActivity(intent);
    }
}