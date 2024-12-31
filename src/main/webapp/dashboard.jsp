<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Management Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="bg-light">
    <div class="container my-5">
        <h1 class="text-center mb-4">Management Dashboard</h1>

        <!-- Navigation Tabs -->
        <ul class="nav nav-tabs" id="dashboardTabs" role="tablist">
            <li class="nav-item">
                <a class="nav-link active" id="products-tab" data-bs-toggle="tab" href="#products" role="tab">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="blocks-tab" data-bs-toggle="tab" href="#blocks" role="tab">Blocks</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="compliances-tab" data-bs-toggle="tab" href="#compliances" role="tab">Compliances</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" id="transactions-tab" data-bs-toggle="tab" href="#transactions" role="tab">Transactions</a>
            </li>
        </ul>

        <!-- Tab Content -->
        <div class="tab-content mt-4">
            <!-- Products Tab -->
            <div class="tab-pane fade show active" id="products" role="tabpanel">
                <h2>Products</h2>
                <form id="productForm">
                    <div class="mb-3">
                        <label for="productName" class="form-label">Product Name</label>
                        <input type="text" id="productName" class="form-control" placeholder="Enter product name">
                    </div>
                    <div class="mb-3">
                        <label for="productDescription" class="form-label">Description</label>
                        <textarea id="productDescription" class="form-control" placeholder="Enter product description"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="productStatus" class="form-label">Status</label>
                        <input type="text" id="productStatus" class="form-control" placeholder="Enter status">
                    </div>
                    <button type="button" class="btn btn-primary" onclick="validateProduct()">Add Product</button>
                </form>
            </div>

            <!-- Blocks Tab -->
            <div class="tab-pane fade" id="blocks" role="tabpanel">
                <h2>Blocks</h2>
                <form id="blockForm">
                    <div class="mb-3">
                        <label for="blockId" class="form-label">Block ID</label>
                        <input type="text" id="blockId" class="form-control" placeholder="Enter block ID">
                    </div>
                    <div class="mb-3">
                        <label for="previousHash" class="form-label">Previous Hash</label>
                        <input type="text" id="previousHash" class="form-control" placeholder="Enter previous hash">
                    </div>
                    <div class="mb-3">
                        <label for="blockData" class="form-label">Data</label>
                        <textarea id="blockData" class="form-control" placeholder="Enter data"></textarea>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="validateBlock()">Add Block</button>
                </form>
            </div>

            <!-- Compliances Tab -->
            <div class="tab-pane fade" id="compliances" role="tabpanel">
                <h2>Compliances</h2>
                <form id="complianceForm">
                    <div class="mb-3">
                        <label for="complianceType" class="form-label">Compliance Type</label>
                        <input type="text" id="complianceType" class="form-control" placeholder="Enter compliance type">
                    </div>
                    <div class="mb-3">
                        <label for="complianceStatus" class="form-label">Status</label>
                        <input type="text" id="complianceStatus" class="form-control" placeholder="Enter status">
                    </div>
                    <div class="mb-3">
                        <label for="complianceDescription" class="form-label">Description</label>
                        <textarea id="complianceDescription" class="form-control" placeholder="Enter description"></textarea>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="validateCompliance()">Add Compliance</button>
                </form>
            </div>

            <!-- Transactions Tab -->
            <div class="tab-pane fade" id="transactions" role="tabpanel">
                <h2>Transactions</h2>
                <form id="transactionForm">
                    <div class="mb-3">
                        <label for="transactionId" class="form-label">Transaction ID</label>
                        <input type="text" id="transactionId" class="form-control" placeholder="Enter transaction ID">
                    </div>
                    <div class="mb-3">
                        <label for="sender" class="form-label">Sender</label>
                        <input type="text" id="sender" class="form-control" placeholder="Enter sender">
                    </div>
                    <div class="mb-3">
                        <label for="receiver" class="form-label">Receiver</label>
                        <input type="text" id="receiver" class="form-control" placeholder="Enter receiver">
                    </div>
                    <div class="mb-3">
                        <label for="transactionDetails" class="form-label">Details</label>
                        <textarea id="transactionDetails" class="form-control" placeholder="Enter transaction details"></textarea>
                    </div>
                    <button type="button" class="btn btn-primary" onclick="validateTransaction()">Add Transaction</button>
                </form>
            </div>
        </div>
    </div>
    <script>
        function validateProduct() {
            const name = document.getElementById("productName").value.trim();
            const description = document.getElementById("productDescription").value.trim();
            const status = document.getElementById("productStatus").value.trim();

            if (!name || !description || !status) {
                alert("All fields are required for adding a product.");
                return;
            }

            alert("Product validated and ready to be added.");
        }

        function validateBlock() {
            const blockId = document.getElementById("blockId").value.trim();
            const previousHash = document.getElementById("previousHash").value.trim();
            const blockData = document.getElementById("blockData").value.trim();

            if (!blockId || !previousHash || !blockData) {
                alert("All fields are required for adding a block.");
                return;
            }

            alert("Block validated and ready to be added.");
        }

        function validateCompliance() {
            const type = document.getElementById("complianceType").value.trim();
            const status = document.getElementById("complianceStatus").value.trim();
            const description = document.getElementById("complianceDescription").value.trim();

            if (!type || !status || !description) {
                alert("All fields are required for adding compliance.");
                return;
            }

            alert("Compliance validated and ready to be added.");
        }

        function validateTransaction() {
            const transactionId = document.getElementById("transactionId").value.trim();
            const sender = document.getElementById("sender").value.trim();
            const receiver = document.getElementById("receiver").value.trim();
            const details = document.getElementById("transactionDetails").value.trim();

            if (!transactionId || !sender || !receiver || !details) {
                alert("All fields are required for adding a transaction.");
                return;
            }

            alert("Transaction validated and ready to be added.");
        }
        
        async function validateBlock() {
            const blockId = document.getElementById("blockId").value.trim();
            const previousHash = document.getElementById("previousHash").value.trim();
            const blockData = document.getElementById("blockData").value.trim();

            if (!blockId || !previousHash || !blockData) {
                alert("All fields are required for adding a block.");
                return;
            }

            // Backend validation example
            const hashExists = await fetch('/api/checkPreviousHash', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ hash: previousHash })
            }).then(res => res.json());

            if (!hashExists.valid) {
                alert("Invalid previous hash.");
                return;
            }

            alert("Block validated successfully!");
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
