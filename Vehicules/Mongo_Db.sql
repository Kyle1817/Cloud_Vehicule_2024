use vehicule;
db.dropDatabase(); 
db.createCollection("messagerie",{
    validator: {
        $jsonSchema : {
            bsonType: "object",
            required: ["id_message","messages","id_utilisateur_em","id_utilisateur_des","new_message"],
            properties: {
                id_message:{
                    bsonType:"int",
                    description :"Cle primaire"
                },
                messages:{
                    bsonType:"string",
                    description :"Contenu message"
                },
                id_utilisateur_em:{
                    bsonType:"int",
                    description:"Id emmeteur"
                },
                id_utilisateur_des:{
                    bsonType:"int",
                    description:"id recepteur"
                },
                new_message:{
                    bsonType:"int",
                    description:"notification"
                }
            }
        }
    }
})

 db.messagerie.insertOne({"id_message":1,"messages":"coucou ?","id_utilisateur_em":1,"id_utilisateur_des":2,"new_message":0})
 db.messagerie.insertOne({"id_message":2,"messages":"coucou cava tyy ?","id_utilisateur_em":2,"id_utilisateur_des":1,"new_message":1})