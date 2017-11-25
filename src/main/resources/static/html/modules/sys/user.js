const baseURL = "http://localhost:9090";

const sexOptions = [
    {key: '1', label: '男'},
    {key: '2', label: '女'}
];

var vm = new Vue({
    el: '#vm',
    data: {
        filters: {
            name: ''
        },

        dataList: [],
        total: 0,
        pageSize: 10,
        currentPage: 1,
        listLoading: false,

        sels: [], // 列表选中列

        saveFormVisible: false, // 编辑界面是否显示
        saveLoading: false,
        saveFormRules: {
            name: [
                {required: true, message: '请输入名称', trigger: 'blur'}
            ]
        },
        dialogStatus: '',
        textMap: {
            query: '查询',
            insert: '创建',
            update: '编辑',
            delete: '删除',
        },
        saveForm: {
            uid: '',
            name: '',
            sex: ''
        },
        name: ''
    },
    mounted: function () {
        this.handleQuery();
    },
    methods: {
        // 分页查询
        handlePage: function (currentPage) {
            this.currentPage = currentPage;
            this.handleQuery();
        },
        handleQuery: function () {
            var vm = this; // keep reference to viewmodel object
            this.listLoading = true;
            NProgress.start();
            var params_ = {pageNo: this.currentPage, pageSize: 10};
            if (this.filters.name && this.filters.name.trim() != "") {
                params_['name'] = this.filters.name;
            }
            console.log(params_);
            axios.get('/user/query', {params: params_})
                .then(function (response) {
                    console.log(response.data);
                    this.total = response.data.total;
                    this.pageSize = response.data.pageSize;
                    this.dataList = response.data.data;
                    for (var key in response.data.data) {
                        this.$set(this.dataList, key, response.data.data[key]);
                    }
                    NProgress.done();
                }.bind(this)).catch(function (error) {
                console.log(error);
            });

            this.listLoading = false;
        },
        handleInsert: function () {
            this.dialogStatus = 'insert';
            this.saveFormVisible = true;
            this.saveForm = {
                uid: '',
                name: '',
                sex: ''
            };
        },
        // 显示编辑界面
        handleUpdate: function (index, row) {
            this.saveForm = Object.assign({}, row);
            this.dialogStatus = 'update';
            this.saveFormVisible = true;
        },
        // 新增或更新
        handleSave: function () {
            this.$refs.saveForm.validate((valid) => {
                if (valid) {
                    this.$confirm('确认提交吗？', '提示', {}).then(() => {
                        this.saveLoading = true;
                    NProgress.start();
                    var params_ = Object.assign({}, this.saveForm);
                    var url = params_.uid != '' ? '/user/update' : '/user/insert';
                    console.log(JSON.stringify(params_));
                    axios.put(baseURL + url, JSON.stringify(params_), {headers:{'Content-Type': 'application/json'}})
                        .then(function (response) {
                            console.log("===============" + response.data.code);
                            this.saveLoading = false;
                            this.saveFormVisible = false;
                            NProgress.done();
                            this.handleQuery(this.currentPage);
                        }.bind(this)).catch(function (error) {
                        console.log(error);
                    });
                });
                }
            });
        },
        handleDelete: function (index, row) {
            this.$confirm('确认删除该记录吗?', '提示', {type: 'warning'}).then(() => {
                this.listLoading = true;
            NProgress.start();
            axios.delete(baseURL + '/user/delete/' + row.uid)
                .then(function (response) {
                    console.log("===============" + response.data.code);
                    this.listMsg('成功', '删除成功', 'success');
                }.bind(this)).catch(function (error) {
                console.log(error);
            });
        }).catch(() => {
            });
        },
        // 批量删除
        handleBatchDelete: function () {
            var uids = this.sels.map(item => item.uid).toString();
            this.$confirm('确认删除选中记录吗？', '提示', {type: 'warning'}).then(() => {
                this.listLoading = true;
            NProgress.start();
            axios.delete(baseURL + '/user/batchdelete/' + uids)
                .then(function (response) {
                    console.log("===============" + response.data.code);
                    this.listMsg('成功', '删除成功', 'success');
                }.bind(this)).catch(function (error) {
                console.log(error);
            });
        }).catch(() => {
            });
        },
        listMsg: function (title, message, type) {
            this.listLoading = false;
            NProgress.done();
            this.$notify({
                title: title,
                message: message,
                type: type
            });
            this.handleQuery();
        },
        selsChange: function (sels) {
            this.sels = sels;
        },
        formatDate: function getNowFormatDate(time) {
            var date = new Date(time);
            var seperator1 = "-";
            var seperator2 = ":";
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate + " " + date.getHours() + seperator2 + date.getMinutes() + seperator2 + date.getSeconds();
            return currentdate;

        },
        formatCreateDate: function (row, column) {
            if (row.createDate != null) {
                return this.formatDate(row.createDate);
            } else {
                return '';
            }
        },
        formatSex: function (row, column) {
            if (row.sex != null) {
                return row.sex == 1 ? '男' : '女';
            }
        },
        queryName: function () {
            this.currentPage = 1;
            this.handleQuery();
        }
    }
});