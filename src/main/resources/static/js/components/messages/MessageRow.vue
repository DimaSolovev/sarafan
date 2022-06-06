<template>
    <v-card class="my-2">
        <v-card-text primary-title>
            <i>({{ message.id }})</i>
            {{ message.text }}
        </v-card-text>
        <v-card-actions>
            <v-btn rounded @click="edit" small flat>Edit</v-btn>
            <v-btn rounded @click="del" small>Delete</v-btn>
            <v-icon
                    large
                    color="green darken-2"
            >
                mdi-domain
            </v-icon>
        </v-card-actions>
    </v-card>
</template>

<script>
    import { mapActions } from 'vuex'
    export default {
        props: ['message', 'editMessage'],
        methods: {
            ...mapActions(['removeMessageAction']),
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.removeMessageAction(this.message)
            }
        }
    }
</script>

<style>
</style>